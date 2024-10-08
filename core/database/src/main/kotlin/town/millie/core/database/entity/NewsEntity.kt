package town.millie.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val country: String,
    val title: String,
    val urlToImage: String?,
    val url: String,
    val publishedAt: String,
)
