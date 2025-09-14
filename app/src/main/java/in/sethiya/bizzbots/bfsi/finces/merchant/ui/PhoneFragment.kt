package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentPhoneBinding
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PhoneRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.viewmodel.PhoneViewModel

class PhoneFragment : Fragment(R.layout.fragment_phone) {

    private var _binding: FragmentPhoneBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PhoneViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnSendPhone.setOnClickListener {
            val phone = binding.etPhone.text.toString()

            val phoneRequest = PhoneRequest(phone)
            viewModel.sendPhone(phoneRequest)
        }

        viewModel.response.observe(viewLifecycleOwner) { response ->
            if (response.success) {
                Toast.makeText(requireContext(), "OTP sent", Toast.LENGTH_SHORT).show()
                (parentFragment as? MainFragment)?.goToOtpScreen()
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
