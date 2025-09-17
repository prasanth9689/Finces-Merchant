package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentPanBinding
import `in`.sethiya.bizzbots.bfsi.finces.merchant.viewmodel.PanViewModel

class PanFragment : Fragment(R.layout.fragment_pan){
    private var _binding: FragmentPanBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PanViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}