package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AuthPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 9
    override fun createFragment(position: Int): Fragment =
        when(position){
            0-> PasscodeFragment() // IntroductionFragment()
            1-> LanguageFragment()
            2-> PhoneFragment()
            3-> OtpFragment()
            4-> PanFragment()
            5-> EmployeeRegFragment()
            6-> PasscodeFragment()
            7-> DeviceRegFragment()
            8-> LoginFragment()
            else -> {
                PhoneFragment()
            }
        }
//        if (position == 0) PhoneFragment() else OtpFragment()
}
