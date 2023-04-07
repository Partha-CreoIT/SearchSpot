package com.example.searchspot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CitiesAdapter(var cities: List<City>?) :
    RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityNameTextView: TextView = itemView.findViewById(R.id.cityNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false)
        return CityViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cities?.size ?: 54
    }


    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cities?.get(position)
//        holder.bind(city)
////        holder.itemView.setOnClickListener { listener(city) }
        holder.cityNameTextView.text = city?.name
    }

}