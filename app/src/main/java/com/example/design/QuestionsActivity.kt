package com.example.design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.design.result.ResultActivity
import com.example.utils.PagerDecorator
import com.example.utils.SpinnerTransformation
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), PagerListener {

    private val adapter by lazy {
        PagerAdapter(this)
    }

    private var questionResult = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        setupViewPager()
        setupListeners()
    }

    private fun setupListeners() {
        next.setOnClickListener {
            pager.currentItem += 1
        }
    }

    override fun onBackPressed() {
        if (pager.currentItem > 0) {
            pager.currentItem -= 1
        } else {
            super.onBackPressed()
            overridePendingTransition(R.anim.slide_left_out, R.anim.slide_right_out)
        }
    }

    private fun setupViewPager() {
        pager.adapter = adapter
        pager.isUserInputEnabled = false
        pager.offscreenPageLimit = 6
        pager.setPageTransformer(SpinnerTransformation())
        pager.addItemDecoration(PagerDecorator())

        adapter.update(generateData())
    }

    private fun generateData(): ArrayList<String> {
        val list = arrayListOf<String>()

        list.add(getString(R.string.app_name))
        list.add(getString(R.string.app_name))
        list.add(getString(R.string.app_name))
        list.add(getString(R.string.app_name))
        list.add(getString(R.string.app_name))
        list.add(getString(R.string.app_name))


        return list
    }


    override fun selectAnswer(answer: Boolean, position: Int) {
        if (answer) questionResult += 20
        nextPage(position)
    }

    override fun selectAnswerFourQuestions(points: Int, position: Int) {
        questionResult += points
        nextPage(position)
    }

    private fun nextPage(position: Int) {
        pager.currentItem += 1

        if (position + 1 == adapter.itemCount) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(POINTS, questionResult)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        const val POINTS = "POINTS"
    }
}