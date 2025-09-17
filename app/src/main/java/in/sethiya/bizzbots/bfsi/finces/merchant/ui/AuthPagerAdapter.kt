package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AuthPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3
    override fun createFragment(position: Int): Fragment =
        when(position){
            0-> PhoneFragment()
            1-> OtpFragment()
            2-> PanFragment()
            else -> {
                PhoneFragment()
            }
        }
//        if (position == 0) PhoneFragment() else OtpFragment()
}
