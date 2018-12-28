package com.marciarocha.movieapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DetailMovie(@SerializedName("id") @Expose val id: Int,
                       @SerializedName("backdrop_path") @Expose val backdropPath: String?,
                       @SerializedName("title") @Expose val title: String,
                       @SerializedName("overview") @Expose val overview: String,
                       @SerializedName("revenue") @Expose val revenue: Int,
                       @SerializedName("runtime") @Expose val runtime: Int?)