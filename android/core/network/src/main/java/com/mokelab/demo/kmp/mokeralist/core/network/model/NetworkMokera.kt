package com.mokelab.demo.kmp.mokeralist.core.network.model

import com.mokelab.demo.kmp.mokeralist.core.model.Mokera
import com.mokelab.demo.kmp.mokeralist.core.model.MokeraId
import kotlinx.serialization.Serializable

/**
 * Data class representing a Mokera in the network layer.
 */
@Serializable
internal data class NetworkMokera(
    val id: String,
    val name: String,
) {
    /**
     * Converts this [NetworkMokera] instance to a [Mokera] model instance.
     *
     * @return A [Mokera] object with the same id and name as this [NetworkMokera].
     */
    internal fun toModel(): Mokera {
        return Mokera(
            id = MokeraId(id),
            name = name,
        )
    }
}
