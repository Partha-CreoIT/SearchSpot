package com.example.searchspotapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.searchspotapp.databinding.ActivityMainBinding

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var cities = mutableListOf<City>()
    fun setCityList(movies: List<City>) {
        this.cities = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivityMainBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        var city= cities[position]
        holder.binding.recyclerView
        Glide.with(holder.itemView.context)
    }
    override fun getItemCount(): Int {
        return cities.size
    }
}
class MainViewHolder(val binding: ActivityMainBinding) : RecyclerView.ViewHolder(binding.root) {
}
//class CitiesAdapter(private var spots: List<City>) :
//    RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {
//
//    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//
//        fun bind(item: City?) {
//            val cityNameTextView: TextView = itemView.findViewById(R.id.cityNameTextView)
//            cityNameTextView.text = item?.name
//
//            itemView.setOnClickListener {
//                val intent = Intent(itemView.context, MainActivity::class.java)
//                intent.putExtra("cityName", item?.name)
//                itemView.context.startActivity(intent)
//
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
//        val itemView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.adapter_city, parent, false)
//        return CityViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//        return spots.size
//    }
//
//
//    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
//        val spot = spots[position]
//        holder.bind(spot)
//    }
//
//}