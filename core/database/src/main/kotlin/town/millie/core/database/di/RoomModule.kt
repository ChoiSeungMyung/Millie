package town.millie.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import town.millie.core.database.dao.NewsDao
import town.millie.core.database.dao.ReadNewsDao
import town.millie.core.database.database.MillieDatabase

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideMillieDatabase(
        @ApplicationContext context: Context,
    ): MillieDatabase {
        return Room
            .databaseBuilder(context, MillieDatabase::class.java, "millie.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        database: MillieDatabase,
    ): NewsDao {
        return database.newsDao()
    }

    @Provides
    @Singleton
    fun provideReadNewsDao(
        database: MillieDatabase,
    ): ReadNewsDao {
        return database.readNewsDao()
    }
}
