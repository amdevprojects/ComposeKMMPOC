package assets.state

import assets.model.Asset

data class AssetsUiState(
    val assets: List<Asset> = listOf()
)
