package `in`.sethiya.bizzbots.bfsi.finces.merchant

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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
    }
}