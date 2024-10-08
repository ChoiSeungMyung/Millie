package town.millie.core.database.source.impl

import javax.inject.Inject
import town.millie.core.database.dao.NewsDao
import town.millie.core.database.entity.NewsEntity
import town.millie.core.database.source.NewsLocalSource

class NewsLocalSourceImpl @Inject constructor(
    private val newsDao: NewsDao,
) : NewsLocalSource {

    override suspend fun insertAllNews(newsList: List<NewsEntity>) {
        newsDao
            .insertAllNews(newsList)
    }

    override suspend fun getNewsByCountry(country: String): List<NewsEntity> {
        return newsDao
            .getNewsListByCountry(
                country = country,
            )
    }
}
