package com.example.design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var color = 0
    private var drawable = 0
    private var spannableString: SpannableString? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListeners()

        val bundle = 12

        if (bundle < 20) {
            color = R.color.colorPrimary
            drawable = R.drawable.bg_white_card
            spannableString = getSPan1()
        } else if (bundle in 21..39){
            color = R.color.colorPrimary
            drawable = R.drawable.bg_white_card
            spannableString = getSPan1()
        }
        parentView.setBackgroundResource(color)
    }

    private fun getSPan1(): SpannableString {
        val span = SpannableString("У вас есть ем")

        span.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.yellow)),
            5,
            11,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        return span
    }

    private fun setupListeners() {
        btnStart.setOnClickListener {
            startActivity(Intent(this, QuestionsActivity::class.java))
        }
    }
}