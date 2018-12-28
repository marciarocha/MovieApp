package com.marciarocha.movieapp

import com.marciarocha.movieapp.data.model.Movie
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.util.*


class CurrentYearTest {

    @Test
    fun TestIsCurrentYear_PastYear_ReturnFalse() {
        val movie1 = Movie(1, "path1", "title1", "2016-01-02")
        assertEquals(movie1.isCurrentYear(), false)
    }

    @Test
    fun TestIsCurrentYear_CurrentYear_ReturnTrue() {
        var cal = Calendar.getInstance()
        val currentYear = cal.get(Calendar.YEAR)
        val movie2 = Movie(2,"path2", "title2", "$currentYear-02-01")
        assertEquals(movie2.isCurrentYear(), true)
    }
}
