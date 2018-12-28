package com.marciarocha.movieapp.data


import com.marciarocha.movieapp.data.local.MovieDao
import com.marciarocha.movieapp.data.model.DetailMovie
import com.marciarocha.movieapp.data.model.Movie
import com.marciarocha.movieapp.data.remote.*
import io.reactivex.Single
import javax.inject.Inject

class DataManager @Inject constructor(private val retrofitService: RetrofitService, private val movieDao:MovieDao) {

    fun searchMoviesByKeyword(query:String): Single<List<Movie>> {
        return retrofitService.getMoviesByQuery(query).map { movieResponse -> movieResponse.results}
                .flatMap { moviesList -> movieDao.clearTable()
                    moviesList.forEach { movieDao.insert(it) }
                    Single.just(moviesList) }
    }

    fun getMoviesFromDatabase(): Single<List<Movie>>{
        return movieDao.getAllMovies()

    }

    fun getMovieDetail(movieId: Int):Single<DetailMovie> {
        return retrofitService.getMovieDetail(movieId)
    }


}