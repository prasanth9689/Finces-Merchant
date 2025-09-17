package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentPanBinding
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.PanVerificationRequest
import `in`.sethiya.bizzbots.bfsi.finces.merchant.viewmodel.PanViewModel

@AndroidEntryPoint
class PanFragment : Fragment(R.layout.fragment_pan){
    private var _binding: FragmentPanBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PanViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnPan.setOnClickListener {
            val pan = binding.edPan.text.toString().trim()
            val panName = binding.edPanName.toString().trim()
            val verificationId = "testverificationid"

            val panRequest = PanVerificationRequest(pan,verificationId, panName)

            viewModel.verifyPan(panRequest)
        }

        viewModel.panResponse.observe(viewLifecycleOwner) { response ->
            response?.let {
                if (it.status == "SUCCESS") {
                    Toast.makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), it.message ?: "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}