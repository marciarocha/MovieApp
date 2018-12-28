package com.marciarocha.movieapp.moviedetail

import com.marciarocha.movieapp.base.BaseContract
import com.marciarocha.movieapp.data.model.DetailMovie
import com.marciarocha.movieapp.data.model.Movie

class MovieDetailContract {

    interface MovieDetailView : BaseContract.IBaseView {
        fun showMovie(movie: DetailMovie)
    }

    interface MovieDetailPresenter : BaseContract.IBasePresenter<MovieDetailView> {
        fun getMoviesById(id: Int)
    }
}