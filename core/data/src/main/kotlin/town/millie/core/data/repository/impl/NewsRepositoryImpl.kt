package town.millie.core.data.repository.impl

import java.io.IOException
import javax.inject.Inject
import town.millie.core.data.repository.NewsRepository
import town.millie.core.database.entity.NewsEntity
import town.millie.core.database.entity.mapper.toEntity
import town.millie.core.database.entity.mapper.toModel
import town.millie.core.database.source.NewsLocalSource
import town.millie.core.model.entity.News
import town.millie.core.network.response.NewsResponse
import town.millie.core.network.response.mapper.toModel
import town.millie.core.network.source.NewsRemoteSource

class NewsRepositoryImpl @Inject constructor(
    private val local: NewsLocalSource,
    private val remote: NewsRemoteSource,
) : NewsRepository {

    override suspend fun fetchHeadlines(country: String): List<News> {
        return remote
            .fetchHeadlines(country)
            .articles
            .map(NewsResponse::toModel)
    }

    override suspend fun getNewsByCountry(country: String): List<News> {
        return try {
            local
                .getNewsByCountry(country)
                .map(NewsEntity::toModel)
                .ifEmpty {
                    fetchHeadlines(
                        country = country,
                    )
                        .also {
                            val newsList = it.map { news ->
                                news.toEntity(
                                    country = country,
                                )
                            }

                            local.insertAllNews(
                                newsList = newsList,
                            )
                        }
                }
        } catch (e: IOException) {
            local
                .getNewsByCountry(country)
                .map(NewsEntity::toModel)
        } catch (e: retrofit2.HttpException) {
            local
                .getNewsByCountry(country)
                .map(NewsEntity::toModel)
        }
    }
}
