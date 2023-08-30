package assets.viewmodel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import assets.model.Asset
import network.KEY_HEADER_API_KEY
import network.Ktor
import network.URL_GET_ASSETS
import network.VALUE_API_KEY
import assets.state.AssetsUiState

class AssetsViewModel: ViewModel() {

    private var _uiState = MutableStateFlow(AssetsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchAssets()
    }

    private fun fetchAssets() {
        viewModelScope.launch {
            val assets = Ktor
                .httpClient
                .get {
                    url(URL_GET_ASSETS)
                    header(KEY_HEADER_API_KEY, VALUE_API_KEY)
                }
                .body<List<Asset>>()
            _uiState.update {
                it.copy(assets = assets)
            }
        }
    }

    override fun onCleared() {
        Ktor.httpClient.close()
    }
}