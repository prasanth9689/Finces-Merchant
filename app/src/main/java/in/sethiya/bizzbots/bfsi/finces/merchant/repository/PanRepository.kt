package `in`.sethiya.bizzbots.bfsi.finces.merchant.repository

import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PanVerificationRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PanVerificationResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import jakarta.inject.Inject
import jakarta.inject.Named

class PanRepository @Inject constructor(
    @Named("clientId") private val clientId: String,
    @Named("clientSecret") private val clientSecret: String
) {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun verifyPan(request: PanVerificationRequest): PanVerificationResponse {
        return client.post("https://sandbox.cashfree.com/verification/pan/advance") {
            contentType(ContentType.Application.Json)
            headers {
                append("x-client-id", clientId)
                append("x-client-secret", clientSecret)
            }
            setBody(request)
        }.body()
    }
}
