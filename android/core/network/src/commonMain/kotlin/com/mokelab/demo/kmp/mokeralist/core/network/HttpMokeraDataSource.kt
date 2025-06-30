package com.mokelab.demo.kmp.mokeralist.core.network

import com.mokelab.demo.kmp.mokeralist.core.model.Mokera
import com.mokelab.demo.kmp.mokeralist.core.network.model.FetchMokerasResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

/**
 * Implementation of [NetworkMokeraDataSource] that fetches Mokeras from a remote server using HTTP.
 *
 * @property baseUrl The base URL of the server to fetch Mokeras from.
 * @property client The HTTP client used to make network requests.
 * @property dispatcher The coroutine dispatcher for executing network requests, defaulting to [Dispatchers.IO].
 */
class HttpMokeraDataSource(
    private val baseUrl: String,
    private val client: HttpClient,
    private val json: Json,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : NetworkMokeraDataSource {
    override suspend fun fetchMokeras(): List<Mokera> = withContext(dispatcher) {
        val response = client.get("$baseUrl/mokeras.json")
        if (response.status.value != 200) {
            throw Exception("Failed to fetch Mokeras: ${response.status.value}")
        }
        val respBody = json.decodeFromString<FetchMokerasResponse>(response.body())
        respBody.mokeras.map { it.toModel() }
    }
}