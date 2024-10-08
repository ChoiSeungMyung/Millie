package town.millie.core.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import town.millie.core.network.source.NewsRemoteSource
import town.millie.core.network.source.impl.NewsRemoteSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteSourceModule {
    @Binds
    @Singleton
    abstract fun bindNewsRemoteSource(
        impl: NewsRemoteSourceImpl,
    ): NewsRemoteSource
}
