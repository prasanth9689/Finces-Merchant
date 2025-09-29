package `in`.sethiya.bizzbots.bfsi.finces.merchant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import `in`.sethiya.bizzbots.bfsi.finces.merchant.R

class AdapterHomeSavings(
    private val context: Context?,
    private val exploreImage: ArrayList<Int>,
    private val exploreName: ArrayList<String>
) : RecyclerView.Adapter<AdapterHomeSavings.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.model_pro_savings, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val res = exploreImage[position]
        holder.images.setImageResource(res)
        holder.text.text = exploreName[position]

        holder.layout.setOnClickListener {
            when (position) {
                /*
                0 -> context.startActivity(Intent(context, Activity::class.java))
                1 -> context.startActivity(Intent(context, Activity::class.java))
                2 -> context.startActivity(Intent(context, Activity::class.java))
                3 -> context.startActivity(Intent(context, Activity::class.java))
                4 -> context.startActivity(Intent(context, Activity::class.java))
                5 -> context.startActivity(Intent(context, Activity::class.java))
                6 -> context.startActivity(Intent(context, Activity::class.java))
                 */
            }
        }
    }

    override fun getItemCount(): Int = exploreImage.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val images: ImageView = view.findViewById(R.id.iconImageView)
        val text: TextView = view.findViewById(R.id.name_text)
        val layout: CardView = view.findViewById(R.id.layout)
    }
}
