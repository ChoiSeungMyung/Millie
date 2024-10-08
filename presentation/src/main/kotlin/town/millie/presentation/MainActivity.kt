package town.millie.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import town.millie.presentation.navigation.MainNavHost

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainNavHost(
                    modifier =
                    Modifier
                        .fillMaxSize(),
                )
            }
        }
    }
}
