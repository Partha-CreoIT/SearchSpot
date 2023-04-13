package com.example.searchspot

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.searchspot.databinding.FetchedSpotBinding

class SpotAdapter1 : RecyclerView.Adapter<MainViewHolder1>() {

    var spotss = mutableListOf<Spot.Result>()
    fun selectSpotList(spots: List<Spot.Result>) {
        this.spotss = spots.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder1 {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FetchedSpotBinding.inflate(inflater, parent, false)
        return MainViewHolder1(binding)
    }

    override fun getItemCount(): Int {
        return spotss.size
    }

    override fun onBindViewHolder(holder: MainViewHolder1, position: Int) {
        val spot = spotss[position]
        holder.bind(spot)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {

        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    }

}

class MainViewHolder1(val binding: FetchedSpotBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Spot.Result?) {
        val cityNameTextView1: TextView = itemView.findViewById(R.id.cityNameTextView1)
        cityNameTextView1.text = item?.name ?: ""
        val cityNameText = item?.name ?: ""
        binding.cityNameTextView1.text = "$cityNameText"


        val category: TextView = itemView.findViewById(R.id.title)
        category.text = item?.categories_name.toString().replace("[", "").replace("]", "")


        val address: TextView = itemView.findViewById(R.id.address)
        val addres = item?.address ?: ""
        val a = "Address: "
        binding.address.text = "$a $addres"

        val imageView: ImageView = itemView.findViewById(R.id.image)
        imageView.load("https://d10y46cwh6y6x1.cloudfront.net/${item?.photo}")


    }
}