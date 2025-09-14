package `in`.sethiya.bizzbots.bfsi.finces.merchant.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.ApiResponse
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PhoneRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.repository.AuthRepository
import kotlinx.coroutines.launch

class PhoneViewModel : ViewModel() {
    private val repository = AuthRepository()
    private val _response = MutableLiveData<ApiResponse>()
    val response: LiveData<ApiResponse> = _response

    fun sendPhone(phoneRequest: PhoneRequest) {
        viewModelScope.launch {
            try {
                val result = repository.sentPhone(phoneRequest)
                _response.postValue(result)
            } catch (e: Exception) {
                _response.postValue(ApiResponse(false, "Error: ${e.message}"))
            }
        }
    }
}
