package com.example.book.library.presentation.authentication.common

import java.util.Calendar

 fun getYearFromEpoch(publishedChapterDate: Int): Int {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = publishedChapterDate.toLong() * 1000
    return calendar.get(Calendar.YEAR)
}