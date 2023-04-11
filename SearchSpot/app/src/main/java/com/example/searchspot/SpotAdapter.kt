package com.example.searchspot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class SpotAdapter(private var spots: List<Spot.Result?>) :
    RecyclerView.Adapter<SpotAdapter.SpotViewHolder>() {

    class SpotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(item: Spot.Result?) {
            val cityNameTextView: TextView = itemView.findViewById(R.id.cityNameTextView1)
            cityNameTextView.text = item?.name


            val category: TextView = itemView.findViewById(R.id.title)
            category.text = item?.categories_name.toString().replace("[", "").replace("]", "")


            val address: TextView = itemView.findViewById(R.id.address)
            address.text = item?.address

            val imageView: ImageView = itemView.findViewById(R.id.image)
            imageView.load("https://d10y46cwh6y6x1.cloudfront.net/${item?.photo}")


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fetched_spot, parent, false)
        return SpotViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return spots.size
    }


    override fun onBindViewHolder(holder: SpotViewHolder, position: Int) {
        val spot = spots[position]
        holder.bind(spot)
    }

}


