package com.example.searchspot

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SpotAdapter(private var spots: List<Spot.Result?>) :
    RecyclerView.Adapter<SpotAdapter.SpotViewHolder>() {

    class SpotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(item: Spot.Result?) {
            val cityNameTextView: TextView = itemView.findViewById(R.id.cityNameTextView)
            cityNameTextView.text = item?.name
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, SpotActivity::class.java)
                itemView.context.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false)
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


