package `in`.sethiya.bizzbots.bfsi.finces.merchant.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.ActivityHomeBinding
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.ModelDashItemBinding
import `in`.sethiya.bizzbots.bfsi.finces.merchant.ui.add_contact.AddContactMain

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.toolbar.menuBtn.setOnClickListener {
           binding.drawerLayout.openDrawer(GravityCompat.START)
       }

        binding.navDrawerLayout.bfsi.setOnClickListener {
            openFragment(BfsiFragment())
            closeDrawer(binding.drawerLayout)
        }

        binding.navDrawerLayout.profileCon.setOnClickListener {
            openFragment(ProfileFragment())
            closeDrawer(binding.drawerLayout)
        }

        binding.navDrawerLayout.aboutUs.setOnClickListener {
            openFragment(AboutUsFragment())
            closeDrawer(binding.drawerLayout)
        }

        binding.navDrawerLayout.myCompany.setOnClickListener {
            openFragment(MyCompFragment())
            closeDrawer(binding.drawerLayout)
        }

        binding.navDrawerLayout.products.setOnClickListener {
            openFragment(ProductsFragment())
            closeDrawer(binding.drawerLayout)
        }

        binding.navDrawerLayout.settings.setOnClickListener {
            openFragment(SettingsFragment())
            closeDrawer(binding.drawerLayout)
        }

        binding.navDrawerLayout.logout.setOnClickListener {
           finish()
        }

        binding.toolbar.addContacts.setOnClickListener {
            val intent = Intent(this, AddContactMain::class.java)
            startActivity(intent)
        }

        loadHome()
    }

    private fun loadHome() {
        val dashboardImage = arrayListOf(
            R.drawable.placeholder_person,
            R.drawable.placeholder_person,
            R.drawable.placeholder_person,
            R.drawable.placeholder_person,
            R.drawable.placeholder_person,
            R.drawable.placeholder_person
        )

        val dashboardName = arrayListOf(
            "Akila",
            "Santhiya",
            "Prasanth",
            "Santhosh",
            "Sangeetha",
            "Priya"
        )

        val dashboardAddress = arrayListOf(
            "Address 635b, 5th Main Road, Ramnagar South, Madipakkam, Madipakkam, Sholinganallur, Kanchipuram, Tamil Nadu, India - 600091",
            "Address 635b, 5th Main Road, Ramnagar South, Madipakkam, Madipakkam, Sholinganallur, Kanchipuram, Tamil Nadu, India - 600091",
            "Address 635b, 5th Main Road, Ramnagar South, Madipakkam, Madipakkam, Sholinganallur, Kanchipuram, Tamil Nadu, India - 600091",
            "Address 635b, 5th Main Road, Ramnagar South, Madipakkam, Madipakkam, Sholinganallur, Kanchipuram, Tamil Nadu, India - 600091",
            "Address 635b, 5th Main Road, Ramnagar South, Madipakkam, Madipakkam, Sholinganallur, Kanchipuram, Tamil Nadu, India - 600091",
            "Address 635b, 5th Main Road, Ramnagar South, Madipakkam, Madipakkam, Sholinganallur, Kanchipuram, Tamil Nadu, India - 600091"
        )

        val linearLayoutManager = LinearLayoutManager(context)
        binding.toolbar.recyclerView.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            setItemViewCacheSize(20)
            adapter = Adapter(context, dashboardImage, dashboardName, dashboardAddress)
        }
    }

    class Adapter(
        private val context: Context,
        private val exploreImage: ArrayList<Int>,
        private val exploreName: ArrayList<String>,
        private val exploreAddress: ArrayList<String>
    ) : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ModelDashItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val res = exploreImage[position]

            Glide.with(context)
                .load(res)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.placeholder_person)
                .into(holder.binding.iconImageView)

            holder.binding.nameText.text = exploreName[position]
            holder.binding.addressText.text = exploreAddress[position]

            holder.binding.layout.setOnClickListener {
//                val intent = Intent(context, ContactDetailsActivity::class.java)
//                context.startActivity(intent)
            }
        }

        override fun getItemCount(): Int = exploreImage.size

        inner class ViewHolder(val binding: ModelDashItemBinding) : RecyclerView.ViewHolder(binding.root)
    }

    fun closeDrawer(drawerLayout: DrawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    private fun openFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(binding.toolbar.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }
}