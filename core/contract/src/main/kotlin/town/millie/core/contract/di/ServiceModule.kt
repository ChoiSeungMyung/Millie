package town.millie.core.contract.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import town.millie.contract.R
import town.millie.core.contract.ApiKey
import town.millie.core.contract.BaseUrl
import town.millie.core.contract.policy.ServicePolicy

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @BaseUrl
    @Provides
    fun provideBaseUrl(
        @ApplicationContext context: Context,
    ): String = context.getString(R.string.server_url)

    @ApiKey
    @Provides
    fun provideApiKey(
        @ApplicationContext context: Context,
    ): String = context.getString(R.string.api_key)

    @Provides
    fun provideServicePolicy(
        @ApplicationContext context: Context,
    ): ServicePolicy =
        ServicePolicy(
            writeTimeout = context.resources.getInteger(R.integer.write_timeout),
            readTimeout = context.resources.getInteger(R.integer.read_timeout),
            connectTimeout = context.resources.getInteger(R.integer.connect_timeout),
        )
}
