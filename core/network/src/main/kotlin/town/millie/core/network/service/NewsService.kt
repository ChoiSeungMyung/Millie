package town.millie.core.network.service

import retrofit2.http.GET
import retrofit2.http.Query
import town.millie.core.network.response.FetchHeadlinesResponse

interface NewsService {
    @GET("/v2/top-headlines")
    suspend fun fetchTopHeadlines(
        @Query("country") country: String,
    ): FetchHeadlinesResponse
}
