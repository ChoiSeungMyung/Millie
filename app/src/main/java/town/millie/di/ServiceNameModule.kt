package town.millie.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import town.millie.R
import town.millie.core.contract.ServiceName

@Module
@InstallIn(SingletonComponent::class)
object ServiceNameModule {
    @ServiceName
    @Provides
    fun provideServiceName(
        @ApplicationContext context: Context,
    ): String = context.getString(R.string.app_name)
}
