package `in`.sethiya.bizzbots.bfsi.finces.merchant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import `in`.sethiya.bizzbots.bfsi.finces.merchant.databinding.ModelDashItemPaymentsBinding

class AdapterHomeLoans(
    private val context: Context,
    private val exploreImage: ArrayList<Int>,
    private val exploreName: ArrayList<String>
) : RecyclerView.Adapter<AdapterHomeLoans.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ModelDashItemPaymentsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val res = exploreImage[position]
        holder.binding.iconImageView.setImageResource(res)
        holder.binding.nameText.text = exploreName[position]

        holder.binding.layout.setOnClickListener {
            when (position) {
                // Example navigation (uncomment and replace with your Activities)
                /*
                0 -> context.startActivity(Intent(context, LoanGoldActivity::class.java))
                1 -> context.startActivity(Intent(context, LoanVehicleActivity::class.java))
                2 -> context.startActivity(Intent(context, LoanPersonalActivity::class.java))
                3 -> context.startActivity(Intent(context, LoanGroupActivity::class.java))
                */
            }
        }
    }

    override fun getItemCount(): Int = exploreImage.size

    inner class ViewHolder(val binding: ModelDashItemPaymentsBinding) :
        RecyclerView.ViewHolder(binding.root)
}
