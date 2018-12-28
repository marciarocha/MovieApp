package com.marciarocha.movieapp


import android.os.Bundle
import android.support.v7.widget.GridLayoutManager

import android.support.v7.widget.SearchView
import com.marciarocha.movieapp.base.BaseActivity
import com.marciarocha.movieapp.data.model.Movie
import com.marciarocha.movieapp.moviedetail.MovieDetailFragment
import com.marciarocha.movieapp.moviemain.MovieMainAdapter
import com.marciarocha.movieapp.moviemain.MovieMainContract
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie_list.*
import javax.inject.Inject

class MovieMainActivity : BaseActivity<MovieMainContract.MovieMainView, MovieMainContract.MovieMainPresenter>(), MovieMainContract.MovieMainView, MovieMainAdapter.OnMovieItemClickListener, SearchView.OnQueryTextListener{

    private val movieAdapter = MovieMainAdapter(this)
    private var movieDetailFragment:MovieDetailFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        movieList.adapter = movieAdapter
        movieList.layoutManager = GridLayoutManager(this, 2)
        movieAdapter.setOnMovieItemClickListener(this)
        search_view.setOnQueryTextListener(this)
        presenter.getLastSearch()
    }

    override fun showMoviesList(movies: List<Movie>) {
        movieAdapter.addItems(movies)
    }

    override fun openMovieDetailFragment(id: Int) {
        movieDetailFragment = supportFragmentManager.findFragmentById(R.id.movie_detail_fragment) as? MovieDetailFragment
        if(movieDetailFragment == null) movieDetailFragment = MovieDetailFragment.newInstance(id)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, movieDetailFragment!!, MovieDetailFragment.javaClass.simpleName)
                .addToBackStack(MovieDetailFragment.javaClass.simpleName)
                .commit()
    }

    override fun onItemClick(id: Int) {
        presenter.onMovieClick(id)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        presenter.searchMovie(query!!)
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return false
    }


}
