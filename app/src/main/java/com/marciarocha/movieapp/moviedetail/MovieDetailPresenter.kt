package com.marciarocha.movieapp.moviedetail

import com.marciarocha.movieapp.base.BasePresenter
import com.marciarocha.movieapp.data.DataManager

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

class MovieDetailPresenter @Inject constructor(private val dataManager: DataManager): BasePresenter<MovieDetailContract.MovieDetailView>(),  MovieDetailContract.MovieDetailPresenter {

    override fun getMoviesById(id: Int) {
        compositeDisposable.add(dataManager.getMovieDetail(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({movie -> view?.showMovie(movie)
                println(movie)},
                        {t -> println(t)})
        )
    }

    override var view: MovieDetailContract.MovieDetailView? = null
}