package com.mokelab.demo.kmp.shared

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

fun createJson(): kotlinx.serialization.json.Json {
    return kotlinx.serialization.json.Json {
        ignoreUnknownKeys = true
    }
}

fun createKtorClient(): HttpClient {
    return HttpClient(Darwin)
}

fun createIoDispatcher(): CoroutineDispatcher {
    return Dispatchers.IO
}