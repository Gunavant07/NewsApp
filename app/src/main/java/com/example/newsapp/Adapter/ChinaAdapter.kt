package com.example.newsapp.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.ArticlesItem
import com.example.newsapp.R

class ChinaAdapter(val activity: FragmentActivity?,val list: ArrayList<ArticlesItem>) : RecyclerView.Adapter<IndiaAdapter.ViewData>() {

    class ViewData(itemView: View): RecyclerView.ViewHolder(itemView){
        var news =itemView.findViewById<TextView>(R.id.txtquotes)
        var image =itemView.findViewById<ImageView>(R.id.imgquotes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndiaAdapter.ViewData {
        var view = LayoutInflater.from(activity).inflate(R.layout.koreanews, parent, false)
        return IndiaAdapter.ViewData(view)
    }

    override fun onBindViewHolder(holder: IndiaAdapter.ViewData, position: Int) {
        Log.e("TAG", "onBindViewHolder: ${list[position].description}" )
        holder.news.setText(list[position].description).toString()
        holder.image.setImageResource(R.drawable.ic_launcher_background)
        Glide.with(activity!!).load(list[position].urlToImage ).into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}