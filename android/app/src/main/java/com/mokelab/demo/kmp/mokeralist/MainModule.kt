package com.mokelab.demo.kmp.mokeralist

import com.mokelab.demo.kmp.mokeralist.core.data.MokeraRepository
import com.mokelab.demo.kmp.mokeralist.core.data.OnlineMokeraRepository
import com.mokelab.demo.kmp.mokeralist.core.network.HttpMokeraDataSource
import com.mokelab.demo.kmp.mokeralist.core.network.NetworkMokeraDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Named("baseUrl")
    @Singleton
    fun provideBaseUrl(): String =
        "https://mokelab.github.io/kmp-demo-mokera-list"

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO)
    }

    @Provides
    @Singleton
    fun provideJson(): kotlinx.serialization.json.Json {
        return kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
        }
    }

    @Provides
    @Named("ioDispatcher")
    @Singleton
    fun provideIoDispatcher(): kotlinx.coroutines.CoroutineDispatcher {
        return kotlinx.coroutines.Dispatchers.IO
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingModule {
    @Binds
    @Singleton
    abstract fun bindMokeraRepository(
        impl: OnlineMokeraRepository,
    ): MokeraRepository

    @Binds
    @Singleton
    abstract fun bindNetworkMokeraDataSource(
        impl: HttpMokeraDataSource,
    ): NetworkMokeraDataSource
}