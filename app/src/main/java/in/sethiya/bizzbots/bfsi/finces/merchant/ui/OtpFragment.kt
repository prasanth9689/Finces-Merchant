package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentOtpBinding
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.OtpRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.viewmodel.OtpViewModel

class OtpFragment : Fragment(R.layout.fragment_otp) {

    private var _binding: FragmentOtpBinding? = null
    private val binding get() = _binding!!

    private val viewModel: OtpViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnVerifyOtp.setOnClickListener {
            val otp = binding.etOtp.text.toString()
            val otpRequest = OtpRequest("", "")
            viewModel.verifyOtp(otpRequest)
        }

        viewModel.response.observe(viewLifecycleOwner) { response ->
            if (response.success) {
                Toast.makeText(requireContext(), "OTP Verified", Toast.LENGTH_SHORT).show()
                // navigate to home screen
            } else {
                Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
