package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentPasscodeBinding

class PasscodeFragment : Fragment(R.layout.fragment_passcode) {

    private var _binding: FragmentPasscodeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentPasscodeBinding.bind(view)

        val keyboard = binding.numberKeyboard
        val phoneInput = binding.phoneInput

        binding.phoneInput.showSoftInputOnFocus = false

        keyboard.onKeyPress = { digit ->
            val old = phoneInput.text.toString()
            val newText = old + digit
            phoneInput.setText(newText)
            phoneInput.setSelection(newText.length)
        }

        keyboard.onDelete = {
            val s = phoneInput.text.toString()
            if (s.isNotEmpty()) {
                phoneInput.setText(s.substring(0, s.length - 1))
                phoneInput.setSelection(phoneInput.text.length)
            }
        }

        keyboard.onCall = {
            val number = phoneInput.text.toString()
            Toast.makeText(requireContext(), "Call pressed: $number", Toast.LENGTH_SHORT).show()
            // Handle call or navigation
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
