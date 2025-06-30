package com.mokelab.demo.kmp.mokeralist.core.network

import com.mokelab.demo.kmp.mokeralist.core.model.Mokera

/**
 * Interface for the network data source that provides Mokera data.
 */
interface NetworkMokeraDataSource {
    /**
     * Fetches a list of Mokeras from the network.
     *
     * @return A list of [Mokera] objects.
     */
    suspend fun fetchMokeras(): List<Mokera>
}