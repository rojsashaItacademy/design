package com.example.design.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import com.example.design.QuestionsActivity.Companion.POINTS
import com.example.design.R
import com.example.utils.ClickSpan
import com.example.utils.ResultEnum
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        setupViews()
    }

    private fun setupViews() {
        val result = ResultEnum.selectTypeOfEnum(intent.getIntExtra(POINTS, -1))

        tvTitle.text = getString(result.textTitle)
        tvSmallDesc.text = getString(result.smallTitle)
        tvBigDesc.text = getString(result.bigDesc)
        tvBigDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, result.textSize)


        tvTitle.setTextColor(resources.getColor(result.color))
        tvSmallDesc.setTextColor(resources.getColor(result.color))

        parentLayout.setBackgroundResource(result.parentDrawable)
        divider.setBackgroundResource(result.drawableDivider)

        ClickSpan.clickify(
            tvBigDesc,
            getString(result.bigDescColored),
            getColor(result.color)
        ) {}
    }
}