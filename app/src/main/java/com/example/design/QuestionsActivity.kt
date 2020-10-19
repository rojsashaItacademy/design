package com.example.design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {

    private val adapter by lazy {
        PagerAdapter()
    }

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

        adapter.update(generateData())
    }

    private fun generateData(): ArrayList<String> {
        val list = arrayListOf<String>()

        list.add("2dasdsadasdasd")
        list.add("hfrefssfsdfdsf")
        list.add("dasdasdasdasdsad")
        list.add("324234324324324234")

        return list
    }
}