package town.millie.feature.newsdetail.ui

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavBackStackEntry
import town.millie.feature.newsdetail.navigation.NEWS_URL

@Composable
internal fun NewsDetailRouter(
    backStackEntry: NavBackStackEntry,
    modifier: Modifier = Modifier,
) {
    val newsUrl = backStackEntry.arguments?.getString(NEWS_URL) ?: return
    NewsDetailScreen(
        url = newsUrl,
        modifier = modifier,
    )
}

@Composable
private fun NewsDetailScreen(
    url: String,
    modifier: Modifier = Modifier,
) {
    AndroidView(
        factory = { context ->
            WebView(context)
                .apply {
                    webViewClient = WebViewClient()
                    loadUrl(url)
                }
        },
        update = { webView ->
            webView.loadUrl(url)
        },
        modifier = modifier
            .fillMaxSize(),
    )
}
