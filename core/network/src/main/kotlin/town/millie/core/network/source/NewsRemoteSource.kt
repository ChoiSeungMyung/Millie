package town.millie.core.network.source

import town.millie.core.network.response.FetchHeadlinesResponse


interface NewsRemoteSource {
    suspend fun fetchHeadlines(
        country: String,
    ): FetchHeadlinesResponse
}
