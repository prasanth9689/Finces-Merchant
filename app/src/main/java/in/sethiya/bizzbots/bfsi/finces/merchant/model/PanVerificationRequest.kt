package `in`.sethiya.bizzbots.bfsi.finces.merchant.model

import kotlinx.serialization.Serializable

@Serializable
data class PanVerificationRequest(
    val pan: String,
    val verification_id: String,
    val name: String
)
