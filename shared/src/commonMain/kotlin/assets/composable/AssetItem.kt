package assets.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import assets.model.Asset
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun AssetItem(asset: Asset) {
    Column(modifier = Modifier.background(Color.White).padding(2.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        KamelImage(
            asyncPainterResource(asset.url),
            contentDescription = null
        )
        Text(text = asset.asset_id)
    }
}