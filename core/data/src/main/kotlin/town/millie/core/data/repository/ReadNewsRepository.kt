package town.millie.core.data.repository

import kotlinx.coroutines.flow.Flow
import town.millie.core.model.entity.ReadNews

interface ReadNewsRepository {

    suspend fun insertReadNews(
        id: String,
        country: String,
    )

    fun getReadNewsByCountry(country: String): Flow<List<ReadNews>>
}
