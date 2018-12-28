package com.marciarocha.movieapp.moviedetail

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.marciarocha.movieapp.R
import com.marciarocha.movieapp.base.BaseFragment
import com.marciarocha.movieapp.data.model.DetailMovie
import com.marciarocha.movieapp.data.remote.BACKDROP_PATH

import kotlinx.android.synthetic.main.fragment_movie_detail.*

private const val MOVIE_ID = "movie_id"


class MovieDetailFragment : BaseFragment<MovieDetailContract.MovieDetailView, MovieDetailContract.MovieDetailPresenter>(), MovieDetailContract.MovieDetailView {

    private var movieID: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieID = it.getInt(MOVIE_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter.getMoviesById(movieID!!)
    }

    companion object {

        @JvmStatic
        fun newInstance(id: Int) =
                MovieDetailFragment().apply {
                    arguments = Bundle().apply {
                        putInt(MOVIE_ID, id)
                    }
                }
    }

    override fun showMovie(movie: DetailMovie) {
        duration.text = getString(R.string.duration)
        duration_value.text = "${movie.runtime} min"
        revenue.text = getString(R.string.revenue)
        revenue_value.text = "${movie.revenue} €"
        overview.text = movie.overview
        movie_title.text = movie.title
        movie.backdropPath?.let{
            Glide.with(activity!!)
                    .load(BACKDROP_PATH + it)
                    .into(backdrop_image)

        }
    }
}
