package com.example.design

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PagerAdapter : RecyclerView.Adapter<PagerViewHolder>() {

    private val list = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_questions, parent, false)
        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun update(list: ArrayList<String>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = list.size

}