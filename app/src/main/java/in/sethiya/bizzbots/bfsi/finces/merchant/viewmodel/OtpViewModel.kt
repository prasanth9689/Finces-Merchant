package `in`.sethiya.bizzbots.bfsi.finces.merchant.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.ApiResponse
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.OtpRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.repository.AuthRepository
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OtpViewModel : ViewModel() {
    private val repository = AuthRepository()
    private val _response = MutableLiveData<ApiResponse>()
    val response: LiveData<ApiResponse> = _response

    fun verifyOtp(otpRequest: OtpRequest) {
        viewModelScope.launch {
            try {
                val result = repository.verifyOtp(otpRequest)
                _response.postValue(result)
            } catch (e: Exception) {
                _response.postValue(ApiResponse(false, "Error: ${e.message}"))
            }
        }
    }
}
