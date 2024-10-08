package town.millie.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import town.millie.feature.newsdetail.navigation.navigateNewsDetailScreen
import town.millie.feature.newsdetail.navigation.newsDetailScreen
import town.millie.feature.newslist.navigation.NEWS_LIST_ROUTE
import town.millie.feature.newslist.navigation.newsListScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = NEWS_LIST_ROUTE,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {

        newsListScreen(
            startNewsDetail = navController::navigateNewsDetailScreen,
        )

        newsDetailScreen()
    }
}
