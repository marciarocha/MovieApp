package com.marciarocha.movieapp.moviemain

import com.marciarocha.movieapp.base.BasePresenter
import com.marciarocha.movieapp.data.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieMainPresenter @Inject constructor(private val dataManager: DataManager): BasePresenter<MovieMainContract.MovieMainView>(), MovieMainContract.MovieMainPresenter {

    override var view: MovieMainContract.MovieMainView? = null

    override fun onMovieClick(id: Int) {
        view?.openMovieDetailFragment(id)
    }

    override fun searchMovie(query: String) {
        compositeDisposable.add(dataManager.searchMoviesByKeyword(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ moviesList ->
                    view?.showMoviesList(moviesList)
                }, {throwable -> println(throwable.message)})
        )
    }

    override fun getLastSearch() {
        compositeDisposable.add(dataManager.getMoviesFromDatabase()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({moviesList -> if (moviesList.isNotEmpty()) view?.showMoviesList(moviesList)
                println(moviesList)},
                        {t ->  println(t.message)})
        )
    }

}