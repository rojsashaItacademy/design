package com.example.design

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_questions.view.*
import kotlinx.android.synthetic.main.item_questions.view.tvCount
import kotlinx.android.synthetic.main.item_questions_four_buttons.view.*

class PagerFourViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(s: String, position: Int, size: Int, listener: PagerListener) {
        itemView.tvCount.text = itemView.context.resources.getString(
            R.string.question_number,
            position + 1,
            size
        )

        itemView.btnOne.setOnClickListener {
            listener.selectAnswerFourQuestions(0, position)
        }
        itemView.btnOne.setOnClickListener {
            listener.selectAnswerFourQuestions(10, position)
        }
        itemView.btnFive.setOnClickListener {
            listener.selectAnswerFourQuestions(15, position)
        }
        itemView.btnTen.setOnClickListener {
            listener.selectAnswerFourQuestions(20, position)
        }
    }
}