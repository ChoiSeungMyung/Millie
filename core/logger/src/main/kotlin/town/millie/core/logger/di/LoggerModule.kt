package town.millie.core.logger.di

import TimberTree
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import town.millie.core.contract.ServiceName
import javax.inject.Singleton
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
object LoggerModule {
    @Provides
    @Singleton
    fun provideTimberTree(
        @ServiceName serviceName: String,
    ): Timber.Tree = TimberTree(serviceName)
}
