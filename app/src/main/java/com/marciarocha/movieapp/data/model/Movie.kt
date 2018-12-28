package com.marciarocha.movieapp.data.model


import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "Movies")
data class Movie(
        @PrimaryKey @SerializedName("id") @Expose val id: Int,
        @ColumnInfo(name= "poster_path") @SerializedName("poster_path") @Expose val posterPath: String?,
        @ColumnInfo(name = "title") @SerializedName("title") @Expose val title: String,
        @ColumnInfo(name="release_date") @SerializedName("release_date") @Expose val releaseDate: String) {

    fun isCurrentYear(): Boolean {
        val dateFormat = SimpleDateFormat("yyyy-MM-d")
        val d = dateFormat.parse(this.releaseDate)

        var cal = Calendar.getInstance()
        val currentYear = cal.get(Calendar.YEAR)
        cal.time = d
        val movieYear = cal.get(Calendar.YEAR)
        return currentYear == movieYear
    }
}