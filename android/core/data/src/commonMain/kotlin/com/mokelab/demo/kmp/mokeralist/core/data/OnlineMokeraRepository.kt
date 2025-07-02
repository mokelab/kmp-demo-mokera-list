package com.mokelab.demo.kmp.mokeralist.core.data

import com.mokelab.demo.kmp.mokeralist.core.model.Mokera
import com.mokelab.demo.kmp.mokeralist.core.network.NetworkMokeraDataSource

/**
 * Repository implementation that fetches Mokeras from a remote server.
 *
 * @property dataSource The network data source used to fetch Mokeras.
 */
class OnlineMokeraRepository constructor(
    private val dataSource: NetworkMokeraDataSource,
) : MokeraRepository {
    override suspend fun getAll(): List<Mokera> {
        return dataSource.fetchMokeras()
    }
}