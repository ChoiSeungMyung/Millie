package town.millie.feature.newslist.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import town.millie.feature.newslist.ui.NewsListRoute

const val NEWS_LIST_ROUTE = "newsListRoute"

fun NavGraphBuilder.newsListScreen(
    startNewsDetail: (String) -> Unit,
) {
    composable(
        route = NEWS_LIST_ROUTE,
    ) {
        NewsListRoute(
            onNewsClick = startNewsDetail,
        )
    }
}
