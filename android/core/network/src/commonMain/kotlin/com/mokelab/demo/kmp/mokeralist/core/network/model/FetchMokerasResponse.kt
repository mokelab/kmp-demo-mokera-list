package com.mokelab.demo.kmp.mokeralist.core.network.model

import kotlinx.serialization.Serializable

@Serializable
internal data class FetchMokerasResponse(
    val mokeras: List<NetworkMokera>
)
