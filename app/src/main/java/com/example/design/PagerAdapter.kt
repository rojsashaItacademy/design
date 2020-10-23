package com.example.design

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PagerAdapter(private val listener: PagerListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TWO_QUESTIONS) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_questions, parent, false)
            PagerViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_questions_four_buttons, parent, false)
            PagerFourViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TWO_QUESTIONS) {
            (holder as PagerViewHolder).bind(list[position], position, list.size, listener)
        } else {
            (holder as PagerFourViewHolder).bind(list[position], position, list.size, listener)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 2) FOUR_QUESTIONS
        else TWO_QUESTIONS
    }

    fun update(list: ArrayList<String>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = list.size

    companion object {
        const val TWO_QUESTIONS = 12
        const val FOUR_QUESTIONS = 13
    }

}