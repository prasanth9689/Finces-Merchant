package `in`.sethiya.bizzbots.bfsi.finces.merchant

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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
                    Toast.makeText(this, "Precise Location Granted", Toast.LENGTH_SHORT).show()
                }
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true -> {
                    Toast.makeText(this, "Approximate Location Granted", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Location Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }

            // Check other permissions too
            permissions.entries.forEach { entry ->
                if (!entry.value) {
                    Toast.makeText(this, "${entry.key} Denied!", Toast.LENGTH_SHORT).show()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() {
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

    private fun checkAndRequestPermissions() {
        val notGranted = requiredPermissions.filter {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }

        if (notGranted.isNotEmpty()) {
            permissionLauncher.launch(notGranted.toTypedArray())
        } else {
            Toast.makeText(this, "Already Granted!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestPermissionsAgain() {
        checkAndRequestPermissions()
    }
}
