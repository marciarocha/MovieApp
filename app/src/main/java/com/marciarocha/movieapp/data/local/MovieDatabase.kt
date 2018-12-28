package com.marciarocha.movieapp.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.marciarocha.movieapp.data.model.Movie

@Database(entities = [(Movie::class)], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}