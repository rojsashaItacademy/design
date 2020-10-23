package com.example.design

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_questions.view.*

class PagerFourViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(s: String, position: Int, size: Int, listener: PagerListener) {
        itemView.tvCount.text = itemView.context.resources.getString(
            R.string.question_number,
            position + 1,
            size
        )

        itemView.btnNo.setOnClickListener {
            listener.selectAnswer(false, position)
        }
        itemView.btnYes.setOnClickListener {
            listener.selectAnswer(true, position)
        }
    }
}