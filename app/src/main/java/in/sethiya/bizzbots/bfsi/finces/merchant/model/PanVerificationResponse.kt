package `in`.sethiya.bizzbots.bfsi.finces.merchant.model

import kotlinx.serialization.Serializable

@Serializable
data class PanVerificationResponse(
    val status: String? = null,
    val message: String? = null
    // add other fields from API response
)