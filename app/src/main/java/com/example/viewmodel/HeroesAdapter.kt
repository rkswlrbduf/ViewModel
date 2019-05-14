package com.example.viewmodel

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_layout.view.*

class HeroesAdapter(var mCtx: Context, var heroList: ArrayList<Hero>?) : RecyclerView.Adapter<HeroesAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        heroList?.let {
            Glide.with(mCtx).load(it[position].imageurl).into(holder.imageView)
            holder.textView.text = it[position].name
        }
    }

    override fun getItemCount(): Int {
        return heroList!!.size
    }

    inner class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView
        var textView: TextView

        init {
            imageView = itemView.imageView
            textView = itemView.textView
        }
    }
}