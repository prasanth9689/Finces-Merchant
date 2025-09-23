package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = AuthPagerAdapter(this)
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = true // disable swipe, control manually

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
           // tab.text = if (pos == 0) "Phone" else "OTP"
            when(pos){
                0 -> tab.text = "Step 1" // Intro
                1 -> tab.text = "Step 2" // Lang
                2 -> tab.text = "Step 3" // Phone
                3 -> tab.text = "Step 4" // OTP
                4 -> tab.text = "Step 5" // PAN
                5 -> tab.text = "Step 6" // Emp Reg
                6 -> tab.text = "Step 7" // Passcode
                7 -> tab.text = "Step 8" // Device reg
                8 -> tab.text = "Step 9" // Login
            }
        }.attach()
    }

    fun goToPanScreen() {
        binding.viewPager.currentItem = 3
    }

    fun goToOtpScreen() {
        binding.viewPager.currentItem = 2
    }


    fun goToPhoneScreen() {
        binding.viewPager.currentItem = 1
    }


    fun goToLanguageScreen() {
        binding.viewPager.currentItem = 0
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
