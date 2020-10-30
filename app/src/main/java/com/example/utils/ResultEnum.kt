package com.example.utils

import com.example.design.R

enum class ResultEnum(
    val parentDrawable: Int,
    val drawableDivider: Int,
    val textTitle: Int,
    val smallTitle: Int,
    val color: Int,
    val bigDesc: Int,
    val bigDescColored: Int,
    val textSize: Float
) {
    GREEN(
        R.drawable.bg_green,
        R.drawable.bg_view_green,
        R.string.title_green,
        R.string.small_desc_green,
        R.color.green,
        R.string.big_desc_green,
        R.string.big_desc_colored,
        17f
    ),
    YELLOW(
        R.drawable.bg_yellow,
        R.drawable.bg_view_yellow,
        R.string.title_yellow,
        R.string.small_desc_yellow,
        R.color.yellow,
        R.string.big_desc_green,
        R.string.big_desc_colored,
        17f
    ),
    ORANGE(
        R.drawable.bg_orange,
        R.drawable.bg_view_orange,
        R.string.title_orange,
        R.string.small_desc_orange,
        R.color.orange,
        R.string.big_desc_green,
        R.string.big_desc_colored,
        15f
    ),
    RED(
        R.drawable.bg_red,
        R.drawable.bg_view_red,
        R.string.title_red,
        R.string.small_desc_red,
        R.color.red,
        R.string.big_desc_green,
        R.string.big_desc_colored,
        17f
    );

    companion object {
        fun selectTypeOfEnum(points: Int): ResultEnum {
            return when {
                points <= 20 -> GREEN
                points in 21..39 -> YELLOW
                points in 40..59 -> ORANGE
                else -> RED
            }
        }
    }
}