package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsViewholder>() {

    private val items = ArrayList<News>()
    class NewsViewholder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val titleView : TextView = itemView.findViewById(R.id.title)
        val author : TextView = itemView.findViewById(R.id.author)
        val image : ImageView = itemView.findViewById(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_home,parent,false)
        val viewholder = NewsViewholder(view)
        return viewholder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsViewholder, position: Int) {
        val currentNews = items[position]
        holder.titleView.text = currentNews.title
        holder.author.text = currentNews.author
    }
    fun updateData(newData:ArrayList<News>){
        items.clear()
        items.addAll(newData)

        notifyDataSetChanged()
    }
}