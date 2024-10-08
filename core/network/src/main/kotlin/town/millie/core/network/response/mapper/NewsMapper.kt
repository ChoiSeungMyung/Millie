package town.millie.core.network.response.mapper

import town.millie.core.model.entity.News
import town.millie.core.network.response.NewsResponse

fun NewsResponse.toModel() = News(
    title = title,
    urlToImage = urlToImage,
    url = url,
    publishedAt = publishedAt,
)
