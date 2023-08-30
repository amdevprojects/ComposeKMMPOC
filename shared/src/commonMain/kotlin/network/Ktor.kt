package network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

object Ktor {

    val httpClient: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }


}