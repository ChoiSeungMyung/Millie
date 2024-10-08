package town.millie.core.database.entity.mapper

import town.millie.core.database.entity.ReadNewsEntity
import town.millie.core.model.entity.ReadNews

fun ReadNewsEntity.toModel() = ReadNews(
    id = id,
    country = country,
)

fun ReadNews.toEntity() = ReadNewsEntity(
    id = id,
    country = country,
)
