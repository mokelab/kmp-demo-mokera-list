package com.mokelab.demo.kmp.mokeralist.core.model

@JvmInline
value class MokeraId(val value: String)

/**
 * Represents a Mokera entity with an ID and a name.
 */
data class Mokera(
    val id: MokeraId,
    val name: String,
)