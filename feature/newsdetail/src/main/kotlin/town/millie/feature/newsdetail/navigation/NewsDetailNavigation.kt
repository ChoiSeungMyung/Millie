package town.millie.feature.newsdetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import town.millie.feature.newsdetail.ui.NewsDetailRouter

const val NEWS_DETAIL_ROUTE = "newsDetailRoute"
const val NEWS_URL = "newsUrl"

fun NavController.navigateNewsDetailScreen(newsUrl: String) {
    navigate("$NEWS_DETAIL_ROUTE/$newsUrl")
}

fun NavGraphBuilder.newsDetailScreen() {
    composable(
        route = "$NEWS_DETAIL_ROUTE/{$NEWS_URL}",
        arguments =
            listOf(
                navArgument(NEWS_URL) { type = NavType.StringType },
            )
    ) { navBackStackEntry ->
        NewsDetailRouter(
            backStackEntry = navBackStackEntry,
        )
    }
}
