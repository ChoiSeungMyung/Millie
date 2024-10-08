package town.millie.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import town.millie.core.network.service.NewsService

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideNewsService(
        retrofit: Retrofit,
    ): NewsService {
        return retrofit.create(NewsService::class.java)
    }
}
