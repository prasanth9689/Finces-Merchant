package `in`.sethiya.bizzbots.bfsi.finces.merchant.retrofit

import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.ApiResponse
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.OtpRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PanRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PhoneRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface APIInterface {
    @POST("finces.php")
    suspend fun sendPhone(@Body request: PhoneRequest): ApiResponse

    @POST("finces.php")
    suspend fun verifyOtp(@Body request: OtpRequest): ApiResponse

    @POST("finces.php")
    suspend fun fetchPan(@Body request: PanRequest): ApiResponse
}