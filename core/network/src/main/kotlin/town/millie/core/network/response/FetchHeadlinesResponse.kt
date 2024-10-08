package town.millie.core.network.response

import kotlinx.serialization.Serializable

@Serializable
data class FetchHeadlinesResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsResponse>
)
