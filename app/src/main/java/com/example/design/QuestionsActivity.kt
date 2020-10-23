package com.example.design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        }
    }

    private fun setupViewPager() {
        pager.adapter = adapter
        pager.isUserInputEnabled = false
        pager.offscreenPageLimit = 6

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
        pager.currentItem += 1
        if (answer) questionResult += 20

        if (position + 1 == adapter.itemCount) {
//            startActivity()
        }
    }
}