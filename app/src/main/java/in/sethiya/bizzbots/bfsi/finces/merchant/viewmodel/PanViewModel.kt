package `in`.sethiya.bizzbots.bfsi.finces.merchant.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PanVerificationRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PanVerificationResponse
import `in`.sethiya.bizzbots.bfsi.finces.merchant.repository.PanRepository
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class PanViewModel @Inject constructor(private val repository: PanRepository) : ViewModel() {

    private val _panResponse = MutableLiveData<PanVerificationResponse?>()
    val panResponse: LiveData<PanVerificationResponse?> get() = _panResponse

    fun verifyPan(panVerificationRequest: PanVerificationRequest) {
        val request = PanVerificationRequest(
            pan = panVerificationRequest.pan,
            verification_id = panVerificationRequest.verification_id,
            name = panVerificationRequest.name
        )

        viewModelScope.launch {
            try {
                val response = repository.verifyPan(request)
                _panResponse.postValue(response)
            } catch (e: Exception) {
                _panResponse.postValue(
                    PanVerificationResponse(status = "ERROR", message = e.message)
                )
            }
        }
    }
}
