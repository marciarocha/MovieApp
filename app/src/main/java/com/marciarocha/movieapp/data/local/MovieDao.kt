package com.marciarocha.movieapp.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.marciarocha.movieapp.data.model.Movie
import io.reactivex.Single

@Dao
interface MovieDao {

    @Query("SELECT * from Movies")
    fun getAllMovies(): Single<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(items: Movie)

    @Query("DELETE FROM Movies")
    fun clearTable()

}