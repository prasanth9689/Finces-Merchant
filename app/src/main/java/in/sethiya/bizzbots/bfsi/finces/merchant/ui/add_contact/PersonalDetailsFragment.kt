package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui.add_contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentLanguageBinding
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentPersonalDetailsBinding

class PersonalDetailsFragment : Fragment(R.layout.fragment_personal_details) {

    private var _binding: FragmentPersonalDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPersonalDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.save.setOnClickListener {
          //  val PersonalDetailsFragment = AddressDetailsFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, AddressDetailsFragment())
            transaction.addToBackStack(null) // Optional, adds to back stack
            transaction.commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
