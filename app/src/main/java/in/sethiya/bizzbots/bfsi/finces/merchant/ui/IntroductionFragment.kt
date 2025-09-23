package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.FragmentIntroductionBinding

class IntroductionFragment : Fragment(R.layout.fragment_introduction) {

    private var _binding: FragmentIntroductionBinding? = null
    private val binding get() = _binding!!

    private val requiredPermissions = arrayOf(
        Manifest.permission.READ_SMS,
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            when {
                permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true -> {
                    Toast.makeText(getContext(), "Precise Location Granted", Toast.LENGTH_SHORT).show()
                }
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true -> {
                    Toast.makeText(getContext(), "Approximate Location Granted", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(getContext(), "Location Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }

            // Check other permissions too
            permissions.entries.forEach { entry ->
                if (!entry.value) {
                    Toast.makeText(getContext(), "${entry.key} Denied!", Toast.LENGTH_SHORT).show()
                }
            }
        }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentIntroductionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.continueWelcomeButton.setOnClickListener {
            binding.privacyPolicyLayout.visibility = View.VISIBLE
            binding.welComeScreenLayout.visibility = View.GONE

            binding.webView.settings.javaScriptEnabled = true

            binding.webView.webViewClient = object : WebViewClient() {
                @Deprecated("Deprecated in Java")
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    return true
                }
            }

            binding.webView.webViewClient = object : WebViewClient() {
                @Deprecated("Deprecated in Java")
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    return true
                }

                override fun onPageFinished(view: WebView, url: String) {
                    super.onPageFinished(view, url)
                    binding.privacyPolicyProgressBar.visibility = View.GONE
                    binding.webView.visibility = View.VISIBLE
                    binding.agreePrivacyPolicyButton.visibility = View.VISIBLE
                }
            }

            binding.agreePrivacyPolicyButton.setOnClickListener {
                binding.privacyPolicyLayout.visibility = View.GONE
                binding.appPermissionsLayout.visibility = View.VISIBLE
            }


            binding.webView.loadUrl("https://contacts.skyblue.co.in/pages/privacy_policy.html")
        }

        binding.appPermissionButton.setOnClickListener {
            binding.appPermissionsLayout.visibility = View.GONE
            //  binding.googleSignInLayout.visibility = View.VISIBLE
        }

        binding.appPermissionButton.setOnClickListener {
            checkAndRequestPermissions()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun checkAndRequestPermissions() {
        val notGranted = requiredPermissions.filter {
            ContextCompat.checkSelfPermission(requireContext(), it) != PackageManager.PERMISSION_GRANTED
        }

        if (notGranted.isNotEmpty()) {
            permissionLauncher.launch(notGranted.toTypedArray())
        } else {
            Toast.makeText(getContext(), "Already Granted!", Toast.LENGTH_SHORT).show()
        }
    }
}