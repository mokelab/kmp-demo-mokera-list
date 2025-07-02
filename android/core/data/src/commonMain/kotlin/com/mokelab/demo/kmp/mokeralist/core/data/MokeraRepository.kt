package com.mokelab.demo.kmp.mokeralist.core.data

import com.mokelab.demo.kmp.mokeralist.core.model.Mokera

/**
 * Repository interface for managing Mokera entities.
 */
interface MokeraRepository {
    /**
     * Fetches all Mokera entities from the repository.
     */
    suspend fun getAll(): List<Mokera>
}