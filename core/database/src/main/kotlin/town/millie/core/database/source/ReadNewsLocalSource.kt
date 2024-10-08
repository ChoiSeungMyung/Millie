package town.millie.core.database.source

import kotlinx.coroutines.flow.Flow
import town.millie.core.database.entity.ReadNewsEntity

interface ReadNewsLocalSource {

    suspend fun insertReadNews(readNews: ReadNewsEntity)

    fun getReadNewsByCountry(country: String): Flow<List<ReadNewsEntity>>
}
