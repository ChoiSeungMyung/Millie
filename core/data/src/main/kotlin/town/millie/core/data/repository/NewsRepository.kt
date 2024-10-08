package town.millie.core.data.repository

import town.millie.core.model.entity.News

interface NewsRepository {
    suspend fun fetchHeadlines(
        country: String,
    ): List<News>

    suspend fun getNewsByCountry(
        country: String,
    ): List<News>
}
