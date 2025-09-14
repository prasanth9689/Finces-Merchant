package `in`.sethiya.bizzbots.bfsi.finces.merchant.retrofit

import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.ApiResponse
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.OtpRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PhoneRequest
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIInterface {
    @POST("finces.php")
    suspend fun sendPhone(@Body request: PhoneRequest): ApiResponse

    @POST("finces.php")
    suspend fun verifyOtp(@Body request: OtpRequest): ApiResponse
}