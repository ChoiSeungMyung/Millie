package town.millie.core.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import town.millie.core.database.dao.NewsDao
import town.millie.core.database.dao.ReadNewsDao
import town.millie.core.database.entity.NewsEntity
import town.millie.core.database.entity.ReadNewsEntity

@Database(
    entities = [
        NewsEntity::class,
        ReadNewsEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class MillieDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
    abstract fun readNewsDao(): ReadNewsDao
}
