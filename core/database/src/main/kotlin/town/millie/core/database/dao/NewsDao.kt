package town.millie.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import town.millie.core.database.entity.NewsEntity

@Dao
interface NewsDao {
    @Query("SELECT * FROM news WHERE country = :country ORDER BY publishedAt DESC")
    suspend fun getNewsListByCountry(
        country: String,
    ): List<NewsEntity>

    @Insert
    suspend fun insertAllNews(newsList: List<NewsEntity>)
}
