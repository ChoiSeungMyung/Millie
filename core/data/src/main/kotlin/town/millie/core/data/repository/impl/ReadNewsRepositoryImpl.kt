package town.millie.core.data.repository.impl

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import town.millie.core.data.repository.ReadNewsRepository
import town.millie.core.database.entity.ReadNewsEntity
import town.millie.core.database.entity.mapper.toModel
import town.millie.core.database.source.ReadNewsLocalSource
import town.millie.core.model.entity.ReadNews

class ReadNewsRepositoryImpl @Inject constructor(
    private val local: ReadNewsLocalSource,
) : ReadNewsRepository {

    override suspend fun insertReadNews(
        id: String,
        country: String,
    ) {
        local.insertReadNews(
            ReadNewsEntity(
                id = id,
                country = country,
            ),
        )
    }

    override fun getReadNewsByCountry(country: String): Flow<List<ReadNews>> {
        return local
            .getReadNewsByCountry(country = country)
            .map { it.map(ReadNewsEntity::toModel) }
    }
}
