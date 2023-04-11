import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager // import LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchspot.City
import com.example.searchspot.MainActivity
import com.example.searchspot.R
import com.example.searchspot.SpotActivity
import com.example.searchspot.databinding.ActivityMainBinding
import com.example.searchspot.databinding.ItemCityBinding

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var cities = mutableListOf<City>()
    fun setCityList(cities : List<City>) {
        this.cities = cities.toMutableList()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCityBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val city = cities[position]
        holder.bind(city)
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {

        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    }
}

class MainViewHolder(val binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: City?) {
        val cityNameTextView: TextView = itemView.findViewById(R.id.cityNameTextView)
        cityNameTextView.text = item?.name
        binding.cityNameTextView.text = item?.name
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, SpotActivity::class.java)
            intent.putExtra("cityName", item?.name)
            itemView.context.startActivity(intent)
        }
    }
}






















//package com.example.searchspot
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.searchspot.databinding.ActivityMainBinding
//
//class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
//
//    var cities = mutableListOf<City>()
//    fun setCityList(cities: List<City>) {
//        this.cities = cities.toMutableList()
//        notifyDataSetChanged()
//    }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = ActivityMainBinding.inflate(inflater, parent, false)
//        return MainViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//        var city = cities[position]
//        holder.binding.recyclerView
//    }
//
//    override fun getItemCount(): Int {
//        return cities.size
//    }
//}
//
//class MainViewHolder(val binding: ActivityMainBinding) : RecyclerView.ViewHolder(binding.root) {
//}
