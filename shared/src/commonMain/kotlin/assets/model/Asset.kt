package assets.model

import kotlinx.serialization.Serializable

@Serializable
data class Asset(
    val asset_id: String,
    val url: String
)