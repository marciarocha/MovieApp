package com.marciarocha.movieapp.data.remote


import com.marciarocha.movieapp.data.model.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = "83d01f18538cb7a275147492f84c3698"
const val POSTER_PATH = "http://image.tmdb.org/t/p/w185/"
const val BACKDROP_PATH = "http://image.tmdb.org/t/p/w780/"

interface RetrofitService {

    @GET("search/movie")
    fun getMoviesByQuery(@Query("query")query: String,@Query("language")language:String="en-EN",  @Query("api_key") apiKey: String = API_KEY):Single<MovieApiResponse<Movie>>

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") id: Int, @Query("api_key") apiKey: String = API_KEY):Single<DetailMovie>

}