package town.millie.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import town.millie.core.contract.BaseUrl
import town.millie.core.contract.ConnectTimeout
import town.millie.core.contract.ReadTimeout
import town.millie.core.contract.WriteTimeout
import town.millie.core.contract.policy.ServicePolicy
import town.millie.core.network.interceptor.HeaderInterceptor
import town.millie.core.network.interceptor.LoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @WriteTimeout
    @Provides
    fun provideWriteTimeout(
        servicePolicy: ServicePolicy,
    ): Long = servicePolicy.writeTimeout.toLong()

    @ReadTimeout
    @Provides
    fun provideReadTimeout(
        servicePolicy: ServicePolicy,
    ): Long = servicePolicy.readTimeout.toLong()

    @ConnectTimeout
    @Provides
    fun provideConnectTimeout(
        servicePolicy: ServicePolicy,
    ): Long = servicePolicy.connectTimeout.toLong()

    @Provides
    @Singleton
    fun provideNetworkJson(): Json =
        Json {
            ignoreUnknownKeys = true
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @WriteTimeout writeTimeout: Long,
        @ReadTimeout readTimeout: Long,
        @ConnectTimeout connectTimeout: Long,
        @HeaderInterceptor headerInterceptor: Interceptor,
        @LoggingInterceptor loggingInterceptor: Interceptor,
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .writeTimeout(writeTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        @BaseUrl baseUrl: String,
        json: Json,
        okHttpClient: OkHttpClient,
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }
}
