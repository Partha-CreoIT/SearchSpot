package com.example.searchspot

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CitiesAdapter(private var spots: List<City>) :
    RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(item: City?) {
            val cityNameTextView: TextView = itemView.findViewById(R.id.cityNameTextView)
            cityNameTextView.text = item?.name

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, SpotActivity::class.java)
                intent.putExtra("cityName", item?.name)
                itemView.context.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false)
        return CityViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return spots.size
    }


    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val spot = spots[position]
        holder.bind(spot)
    }

}