package com.mokelab.demo.kmp.mokeralist.core.network

import com.mokelab.demo.kmp.mokeralist.core.model.Mokera
import com.mokelab.demo.kmp.mokeralist.core.model.MokeraId
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.headersOf
import kotlinx.serialization.json.Json

class HttpMokeraDataSourceTest : FunSpec({
    context("HttpMokeraDataSource with ktor MockEngine") {
        test("should fetch Mokeras from the network using ktor mock") {
            // Given
            val baseUrl = "https://example.com"
            val mockResponse = """{
                "mokeras":
                [
                    {"id":"1","name":"Mokera1"},
                    {"id":"2","name":"Mokera2"}
                ]
            }""".trimIndent()
            val mockEngine = MockEngine { request ->
                respond(
                    content = mockResponse,
                    headers = headersOf("Content-Type" to listOf("application/json"))
                )
            }
            val client = HttpClient(mockEngine)
            val json = Json { ignoreUnknownKeys = true }
            val dataSource = HttpMokeraDataSource(baseUrl, client, json)

            // When
            val mokeras = dataSource.fetchMokeras()

            // Then
            mokeras shouldBe listOf(
                Mokera(MokeraId("1"), "Mokera1"),
                Mokera(MokeraId("2"), "Mokera2")
            )
        }
    }
})
