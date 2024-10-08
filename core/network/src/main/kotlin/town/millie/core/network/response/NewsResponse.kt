package town.millie.core.network.response

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val title: String,
    val urlToImage: String?,
    val url: String,
    val publishedAt: String,
)
