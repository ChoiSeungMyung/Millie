package town.millie.feature.newslist.ui

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.PersistentList
import town.millie.core.model.entity.News
import town.millie.feature.newslist.ui.widget.EmptyResult
import town.millie.feature.newslist.ui.widget.NewsCard

@Composable
internal fun NewsListRoute(
    onNewsClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val viewModel = hiltViewModel<NewsListViewModel>()
    val news by viewModel.news.collectAsStateWithLifecycle()

    NewsListScreen(
        news = news,
        onNewsClick = onNewsClick,
        onReadNews = viewModel::updateReadNews,
        modifier = modifier,
    )
}

@Composable
private fun NewsListScreen(
    news: PersistentList<Pair<News, Boolean>>,
    onNewsClick: (String) -> Unit,
    onReadNews: (News) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (news.isEmpty()) {
        EmptyResult()
    } else {
        val cellCount = if (LocalConfiguration.current.screenWidthDp.dp >= 600.dp) 3 else 1
        LazyVerticalGrid(
            verticalArrangement = spacedBy(8.dp),
            horizontalArrangement = spacedBy(4.dp),
            columns = GridCells.Fixed(count = cellCount),
            modifier = modifier
                .fillMaxSize(),
        ) {
            items(
                items = news,
                key = { (news, _) -> news.toString() },
            ) { (news, read) ->
                NewsCard(
                    news = news,
                    read = read,
                    modifier = Modifier
                        .clickable {
                            val url = Uri.encode(news.url)
                            onReadNews(news)
                            onNewsClick(url)
                        },
                )
            }
        }
    }
}
