package town.millie.core.database.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import town.millie.core.database.source.NewsLocalSource
import town.millie.core.database.source.ReadNewsLocalSource
import town.millie.core.database.source.impl.NewsLocalSourceImpl
import town.millie.core.database.source.impl.ReadNewsLocalSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {
    @Binds
    abstract fun bindNewsLocalSource(
        impl: NewsLocalSourceImpl,
    ): NewsLocalSource

    @Binds
    abstract fun bindReadNewsLocalSource(
        impl: ReadNewsLocalSourceImpl,
    ): ReadNewsLocalSource
}
