package town.millie.core.model.entity

data class News(
    val title: String,
    val urlToImage: String?,
    val url: String,
    val publishedAt: String,
) {
    override fun toString(): String {
        return title + urlToImage + url + publishedAt
    }
}
