package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.adapter.AdapterHomeSavings
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentProductsBinding
import `in`.sethiya.bizzbots.bfsi.finces.merchant.adapter.AdapterHomeInvestments
import `in`.sethiya.bizzbots.bfsi.finces.merchant.adapter.AdapterHomeLoans

class ProductsFragment : Fragment(R.layout.fragment_products) {

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.recyclerViewBanking.isNestedScrollingEnabled = false
        binding.recyclerViewBanking.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        binding.recyclerViewSavings.isNestedScrollingEnabled = false
        binding.recyclerViewSavings.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        binding.recyclerViewInvestments.isNestedScrollingEnabled = false
        binding.recyclerViewInvestments.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.recyclerViewLoans.isNestedScrollingEnabled = false
        binding.recyclerViewLoans.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.recyclerViewInsurance.isNestedScrollingEnabled = false
        binding.recyclerViewInsurance.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.recyclerViewPayments.isNestedScrollingEnabled = false
        binding.recyclerViewPayments.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        loadBanking() // Row 1

        binding.logout.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .remove(this)
                .commit()
        }
    }

    private fun loadBanking() {
        val dashboardImage = arrayListOf(
            R.drawable.ic_report_new,
            R.drawable.ic_report_new,
            R.drawable.ic_report_new
        )

        val dashboardName = arrayListOf(
            "Create account",
            "Select account",
            "View all accounts"
        )

        binding.recyclerViewBanking.layoutManager = GridLayoutManager(context, 3)
        binding.recyclerViewBanking.setHasFixedSize(true)
        binding.recyclerViewBanking.setItemViewCacheSize(20)

        val adapter = AdapterHomeSavings(context, dashboardImage, dashboardName)
        binding.recyclerViewBanking.adapter = adapter

        loadSavings() // Row 2
    }

    private fun loadSavings() {
        val dashboardImage = arrayListOf(
            R.drawable.ic_report_new,
            R.drawable.ic_report_new,
            R.drawable.ic_report_new,
            R.drawable.ic_report_new,
            R.drawable.ic_report_new,
            R.drawable.ic_report_new,
            R.drawable.ic_report_new
        )

        val dashboardName = arrayListOf(
            "DD",
            "RD",
            "FD",
            "MIS",
            "Savings",
            "Gold",
            "Chits"
        )

        binding.recyclerViewSavings.layoutManager = GridLayoutManager(context, 3)
        binding.recyclerViewSavings.setHasFixedSize(true)
        binding.recyclerViewSavings.setItemViewCacheSize(20)

        val adapter = AdapterHomeSavings(context, dashboardImage, dashboardName)
        binding.recyclerViewSavings.adapter = adapter

        loadLoans() // Row 3
    }

    private fun loadInvestments() {
        val dashboardImage = arrayListOf(
            R.drawable.ic_report_new,
            R.drawable.ic_report_new
        )

        val dashboardName = arrayListOf(
            "FD",
            "MIS"
        )

        binding.recyclerViewInvestments.apply {
            layoutManager = GridLayoutManager(context, 3)
            setHasFixedSize(true)
            setItemViewCacheSize(20)
            adapter = AdapterHomeInvestments(context, dashboardImage, dashboardName)
        }

        loadPayments() // Row 5
    }

    private fun loadPayments() {
            val dashboardImage = arrayListOf(
                R.drawable.ic_report_new,
                R.drawable.ic_report_new,
                R.drawable.ic_report_new,
                R.drawable.ic_report_new,
                R.drawable.ic_report_new,
                R.drawable.ic_report_new,
                R.drawable.ic_report_new
            )

            val dashboardName = arrayListOf(
                "DMR",
                "AEPS",
                "MPOS",
                "QR PAY",
                "Recharge",
                "BBPS",
                "Utility"
            )

            binding.recyclerViewPayments.apply {
                layoutManager = GridLayoutManager(context, 3)
                setHasFixedSize(true)
                setItemViewCacheSize(20)
                isNestedScrollingEnabled = false
                adapter = AdapterHomeLoans(requireContext(), dashboardImage, dashboardName)
            }
    }

    private fun loadLoans() {
        val dashboardImage = arrayListOf(
            R.drawable.ic_report_new,
            R.drawable.ic_report_new,
            R.drawable.ic_report_new,
            R.drawable.ic_report_new
        )

        val dashboardName = arrayListOf(
            "Gold",
            "Vehicle",
            "Personal",
            "Group"
        )

        binding.recyclerViewLoans.apply {
            layoutManager = GridLayoutManager(context, 3)
            setHasFixedSize(true)
            setItemViewCacheSize(20)
            adapter = AdapterHomeLoans(context, dashboardImage, dashboardName)
        }
        loadInvestments() // Row 4
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
