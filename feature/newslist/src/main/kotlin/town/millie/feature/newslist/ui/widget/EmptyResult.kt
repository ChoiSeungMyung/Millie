package town.millie.feature.newslist.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import town.millie.core.designsystem.R

@Composable
fun EmptyResult(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize(),
    ) {
        Text(
            text = stringResource(R.string.empty_result),
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
@Preview
private fun EmptyResultPreview() {
    MaterialTheme {
        EmptyResult()
    }
}
