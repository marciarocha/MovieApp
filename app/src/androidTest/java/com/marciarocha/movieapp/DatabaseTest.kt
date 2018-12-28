package com.marciarocha.movieapp

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.marciarocha.movieapp.data.local.MovieDao
import com.marciarocha.movieapp.data.local.MovieDatabase
import com.marciarocha.movieapp.data.model.Movie
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Before

@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var movieDao: MovieDao
    private lateinit var movieDatabase: MovieDatabase

    @Before
    fun createDb() {
        movieDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), MovieDatabase::class.java).build()
        movieDao = movieDatabase.movieDao()
    }

    @Test
    fun getMovies() {
        val movie1 = Movie(1, "path1", "title1", "release1")
        val movie2 = Movie(2, "path2", "title2", "release2")

        movieDao.insert(movie1)
        movieDao.insert(movie2)

        movieDao.getAllMovies().test().assertValue { movies -> movies.count() == 2}

    }

    @After
    fun closeDb() {
        movieDatabase.close()
    }
}
