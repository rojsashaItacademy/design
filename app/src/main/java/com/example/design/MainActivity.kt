package com.example.design

import android.animation.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.widget.TextView
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
        } else if (bundle in 21..39) {
            color = R.color.colorPrimary
            drawable = R.drawable.bg_white_card
            spannableString = getSPan1()
        }
        parentView.setBackgroundResource(color)
//        startValueAnimator(view = tvFirst, delay = 300, duration = 2000)
//        startValueAnimator(view = tvSecond, delay = 300, duration = 2000)
//        startValueAnimator(view = tvThird, delay = 300, duration = 2000)
        inputAnimation(tvThird)
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

    fun inputAnimation(view: TextView) {
        val text = getString(R.string.tv_third)
        val anim = ValueAnimator.ofInt(0, text.length - 1)
//
        var prev = -1
        anim.addUpdateListener {
            val pos = it.animatedValue as Int
            if (prev != pos) {
                view.text = "${view.text}${text[pos]}"
                prev = pos
            }

        }
        anim.duration = (text.length * 100L)
//        for (i in text.indices) {
//            Thread.sleep(250)
//            view.text = "${view.text}${text[i]}"
//        }
        anim.start()
    }

    fun startValueAnimator(
        view: View,
        delay: Long = 1000,
        duration: Long = 200,
        alphaEnd: Float = 1.0f
    ) {
        val animation1 = ValueAnimator.ofFloat(1f, 0f, 1f)
        animation1.duration = duration

        animation1.addUpdateListener {
            view.alpha = it.animatedValue as Float
        }

        animation1.repeatCount = 100

        animation1.start()

    }

    fun startObjectAnimator(
        view: View,
        delay: Long = 1000,
        duration: Long = 200,
        alphaEnd: Float = 1.0f
    ) {
        val animation1 = ObjectAnimator.ofFloat(view, "translationX", -100f)
        val animation2 = ObjectAnimator.ofFloat(view, "translationX", 100f)
        val animation3 = ObjectAnimator.ofFloat(view, "translationX", 0f)


        animation1.duration = duration
        animation2.duration = duration
        animation3.duration = duration

        val animatorSet = AnimatorSet()

        animatorSet
            .playSequentially(animation1, animation2, animation3)

        animatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                animatorSet.start()
            }
        })

        animatorSet.start()
    }

    fun startHideAnimation(
        view: View,
        delay: Long = 1000,
        duration: Long = 200,
        alphaEnd: Float = 1.0f
    ) {
        val animation1 = AlphaAnimation(0.0f, alphaEnd).apply {
            interpolator = AccelerateDecelerateInterpolator()
        }
        animation1.duration = duration
        animation1.startOffset = delay
        animation1.fillAfter = true
        view.startAnimation(animation1)
    }

    private fun setupListeners() {
        btnStart.setOnClickListener {
            startActivity(Intent(this, QuestionsActivity::class.java))
            overridePendingTransition(R.anim.slide_left, R.anim.slide_right)
        }
    }
}