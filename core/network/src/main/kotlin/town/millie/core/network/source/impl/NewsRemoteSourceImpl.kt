package town.millie.core.network.source.impl

import javax.inject.Inject
import town.millie.core.network.response.FetchHeadlinesResponse
import town.millie.core.network.service.NewsService
import town.millie.core.network.source.NewsRemoteSource

class NewsRemoteSourceImpl
@Inject
constructor(
    private val service: NewsService,
) : NewsRemoteSource {
    override suspend fun fetchHeadlines(country: String): FetchHeadlinesResponse {
        return service
            .fetchTopHeadlines(
                country = country,
            )
    }
}
