package town.millie.core.database.source

import town.millie.core.database.entity.NewsEntity

interface NewsLocalSource {
    suspend fun insertAllNews(newsList: List<NewsEntity>)

    suspend fun getNewsByCountry(country: String): List<NewsEntity>
}
