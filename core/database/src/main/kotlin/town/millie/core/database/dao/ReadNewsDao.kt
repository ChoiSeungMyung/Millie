package town.millie.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import town.millie.core.database.entity.ReadNewsEntity

@Dao
interface ReadNewsDao {
    @Query("SELECT * FROM read_news WHERE country = :country")
    fun getReadNewsByCountry(
        country: String,
    ): Flow<List<ReadNewsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReadNews(news: ReadNewsEntity)
}
