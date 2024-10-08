package town.millie.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import town.millie.core.data.repository.NewsRepository
import town.millie.core.data.repository.ReadNewsRepository
import town.millie.core.data.repository.impl.NewsRepositoryImpl
import town.millie.core.data.repository.impl.ReadNewsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindNewsRepository(
        impl: NewsRepositoryImpl,
    ): NewsRepository

    @Binds
    @Singleton
    abstract fun bindReadNewsRepository(
        impl: ReadNewsRepositoryImpl,
    ): ReadNewsRepository
}
