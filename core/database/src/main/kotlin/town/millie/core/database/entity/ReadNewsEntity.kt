package town.millie.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "read_news")
data class ReadNewsEntity(
    @PrimaryKey val id: String,
    val country: String,
)
