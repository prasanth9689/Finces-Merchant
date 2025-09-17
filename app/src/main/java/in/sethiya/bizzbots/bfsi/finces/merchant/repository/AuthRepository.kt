package `in`.sethiya.bizzbots.bfsi.finces.merchant.repository

import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.ApiResponse
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.OtpRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PanVerificationRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PhoneRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.retrofit.RetrofitInstance

class AuthRepository{
    private val contactsService = RetrofitInstance.fincesService

    suspend fun sentPhone(phoneRequest: PhoneRequest): ApiResponse {
        return contactsService.sendPhone(phoneRequest)
    }

    suspend fun verifyOtp(otpRequest: OtpRequest): ApiResponse {
        return contactsService.verifyOtp(otpRequest)
    }

    suspend fun fetchPan(panRequest: PanVerificationRequest): ApiResponse {
        return contactsService.fetchPan(panRequest)
    }
//    suspend fun sendPhone(phone: String) = api.sendPhone(PhoneRequest(phone))
//    suspend fun verifyOtp(phone: String, otp: String) = api.verifyOtp(OtpRequest(phone, otp))
}
