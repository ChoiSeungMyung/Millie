package town.millie.core.database.source.impl

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import town.millie.core.database.dao.ReadNewsDao
import town.millie.core.database.entity.ReadNewsEntity
import town.millie.core.database.source.ReadNewsLocalSource

class ReadNewsLocalSourceImpl @Inject constructor(
    private val readNewsDao: ReadNewsDao,
) : ReadNewsLocalSource {

    override suspend fun insertReadNews(readNews: ReadNewsEntity) {
        readNewsDao.insertReadNews(readNews)
    }

    override fun getReadNewsByCountry(country: String): Flow<List<ReadNewsEntity>> {
        return readNewsDao.getReadNewsByCountry(country)
    }
}
