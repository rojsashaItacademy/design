package com.example.design

interface PagerListener {

    fun selectAnswer(answer: Boolean, position: Int)
    fun selectAnswerFourQuestions(points: Int, position: Int)
}