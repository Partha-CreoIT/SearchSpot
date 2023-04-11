package com.example.searchspot

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.searchspot.databinding.ActivitySpotBinding

class SpotAdapter1 : RecyclerView.Adapter<MainViewHolder1>() {

    var spots = mutableListOf<Spot>()
    fun selectSpotList(spots: List<Spot>) {
        this.spots = spots.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder1 {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivitySpotBinding.inflate(inflater, parent, false)
        return MainViewHolder1(binding)
    }

    override fun getItemCount(): Int {
       return spots.size
    }

    override fun onBindViewHolder(holder: MainViewHolder1, position: Int) {
        val spot = spots[position]
        holder.bind(spots)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {

        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    }

}

class MainViewHolder1(val binding: ActivitySpotBinding) : RecyclerView.ViewHolder(binding.root) {
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