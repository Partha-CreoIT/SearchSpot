package com.example.searchspot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SpotAdapter(var spots: List<Spot.Result?>) :
    RecyclerView.Adapter<SpotAdapter.SpotViewHolder>() {

    class SpotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(item: Spot.Result?){
            val cityNameTextView: TextView = itemView.findViewById(R.id.cityNameTextView)
            cityNameTextView.text = item?.name
            itemView.setOnClickListener {


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false)
        return SpotViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return spots?.size ?: 54
    }


    override fun onBindViewHolder(holder: SpotViewHolder, position: Int) {
        val spot = spots?.get(position)
        holder.bind(spot)
    }

}