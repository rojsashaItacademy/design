package com.example.design.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.example.design.QuestionsActivity.Companion.POINTS
import com.example.design.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val points = intent.getIntExtra(POINTS, -1)

        when {
            points <= 20 -> {
                parentLayout.setBackgroundResource(R.drawable.bg_green)
                divider.setBackgroundResource(R.drawable.bg_view_green)
                tvTitle.text = getString(R.string.title_green)
                tvSmallDesc.text = getString(R.string.small_desc_green)
                tvBigDesc.text = getGreedSpan()
                tvTitle.setTextColor(resources.getColor(R.color.green))
                tvSmallDesc.setTextColor(resources.getColor(R.color.green))
            }
            points in 21..39 -> {
                parentLayout.setBackgroundResource(R.drawable.bg_yellow)
                divider.setBackgroundResource(R.drawable.bg_view_yellow)
                tvTitle.text = getString(R.string.title_yellow)
                tvSmallDesc.text = getString(R.string.small_desc_yellow)
                tvBigDesc.text = getGreedSpan()
                tvTitle.setTextColor(resources.getColor(R.color.yellow))
                tvSmallDesc.setTextColor(resources.getColor(R.color.yellow))
            }
            points in 40..59 -> {
                parentLayout.setBackgroundResource(R.drawable.bg_orange)
                divider.setBackgroundResource(R.drawable.bg_view_orange)
                tvTitle.text = getString(R.string.title_orange)
                tvSmallDesc.text = getString(R.string.small_desc_orange)
                tvBigDesc.text = getGreedSpan()
                tvTitle.setTextColor(resources.getColor(R.color.orange))
                tvSmallDesc.setTextColor(resources.getColor(R.color.orange))
            }
            else -> {
                parentLayout.setBackgroundResource(R.drawable.bg_red)
                divider.setBackgroundResource(R.drawable.bg_view_red)
                tvTitle.text = getString(R.string.title_red)
                tvSmallDesc.text = getString(R.string.small_desc_red)
                tvBigDesc.text = getGreedSpan()
                tvTitle.setTextColor(resources.getColor(R.color.red))
                tvSmallDesc.setTextColor(resources.getColor(R.color.red))
            }
        }
    }

    private fun getGreedSpan(): SpannableString {
        val span = SpannableString(getString(R.string.big_desc_green))
        span.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.green)),
            180,
            200,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        return span
    }
}