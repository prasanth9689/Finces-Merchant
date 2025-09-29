package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui.add_contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentEduOccupDetailsBinding
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentIdentityDetailsBinding

class EduOccupDetailsFragment : Fragment(R.layout.fragment_edu_occup_details) {

    private var _binding: FragmentEduOccupDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentEduOccupDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.save.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, RelCommDetailsFragment())
            transaction.addToBackStack(null) // Optional, adds to back stack
            transaction.commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
