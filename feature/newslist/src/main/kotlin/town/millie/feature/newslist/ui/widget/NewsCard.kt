package town.millie.feature.newslist.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import town.millie.core.model.entity.News

@Composable
internal fun NewsCard(
    news: News,
    read: Boolean,
    modifier: Modifier = Modifier,
) {
    val titleColor = if (read) Color.Red else Color.Black
    Card(
        elevation = 0.dp,
        shape = RectangleShape,
        modifier = modifier
            .background(
                color = Color.LightGray,
            ),
    ) {
        Column(
            verticalArrangement = spacedBy(4.dp),
            modifier = Modifier,
        ) {
            AsyncImage(
                model = news.urlToImage,
                contentScale = ContentScale.Crop,
                contentDescription = "News image",
                modifier = Modifier
                    .aspectRatio(1f)
                    .background(
                        color = Color.LightGray,
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                    ),
            )

            Text(
                text = news.title,
                maxLines = 2,
                color = titleColor,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = news.publishedAt,
                maxLines = 1,
                modifier = Modifier
                    .basicMarquee(),
            )
        }
    }
}

@Preview
@Composable
private fun NewsCardPreview() {
    MaterialTheme {
        NewsCard(
            news = News(
                title = "College football winners and losers: With Alabama's loss, will Ohio State or Texas move to No. 1? - Yahoo Sports",
                urlToImage = "https://s.yimg.com/ny/api/res/1.2/AWe0JoAWbInt5XhVPbB3aQ--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD04MDA-/https://s.yimg.com/os/creatr-uploaded-images/2024-09/a0e46570-8380-11ef-bcb7-c1b9989aec2d",
                url = "https://www.dw.com/en/haiti-gang-opens-fire-killing-at-least-70-people/a-70410530",
                publishedAt = "2024-10-06T04:35:00Z",
            ),
            read = true,
        )
    }
}
