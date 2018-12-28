package com.marciarocha.movieapp.moviemain

import com.marciarocha.movieapp.base.BaseContract
import com.marciarocha.movieapp.data.model.Movie

interface MovieMainContract {

    interface MovieMainView : BaseContract.IBaseView {
        fun showMoviesList(movies: List<Movie>)
        fun openMovieDetailFragment(id: Int)
    }

    interface MovieMainPresenter : BaseContract.IBasePresenter<MovieMainView> {
        fun getLastSearch()
        fun searchMovie(query:String)
        fun onMovieClick(id: Int)
    }
}