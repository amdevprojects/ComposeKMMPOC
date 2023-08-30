import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import assets.composable.AssetScreen
import assets.viewmodel.AssetsViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        val viewModel = getViewModel(Unit, viewModelFactory { AssetsViewModel() })
        AssetScreen(viewModel)
    }
}

expect fun getPlatformName(): String