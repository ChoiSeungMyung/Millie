package town.millie.core.network.interceptor

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import town.millie.core.contract.ApiKey

@Module
@InstallIn(SingletonComponent::class)
object InterceptorModule {
    @LoggingInterceptor
    @Provides
    fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @HeaderInterceptor
    @Provides
    fun provideHeaderInterceptor(
        @ApiKey
        apiKey: String,
    ): Interceptor {
        return Interceptor { chain ->
            val request = chain
                .request()
                .newBuilder()
                .addHeader("X-Api-Key", apiKey)
                .build()

            chain.proceed(request)
        }
    }
}
