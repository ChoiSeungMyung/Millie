package town.millie.core.database.entity.mapper

import town.millie.core.database.entity.NewsEntity
import town.millie.core.model.entity.News

fun NewsEntity.toModel() = News(
    title = title,
    urlToImage = urlToImage,
    url = url,
    publishedAt = publishedAt,
)

fun News.toEntity(
    country: String,
) = NewsEntity(
    title = title,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    url = url,
    country = country,
)
