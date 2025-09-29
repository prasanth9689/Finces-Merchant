package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui.add_contact

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentEduOccupDetailsBinding
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentRelCommDetailsBinding
import `in`.sethiya.bizzbots.bfsi.finces.merchant.ui.Home

class RelCommDetailsFragment : Fragment(R.layout.fragment_rel_comm_details) {

    private var _binding: FragmentRelCommDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRelCommDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.save.setOnClickListener {
            val intent = Intent(requireActivity(), Home::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            requireActivity().startActivity(intent)
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
