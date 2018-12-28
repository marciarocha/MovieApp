package com.marciarocha.movieapp.di.module

import android.content.Context
import com.marciarocha.movieapp.MovieMainActivity
import com.marciarocha.movieapp.moviedetail.MovieDetailContract
import com.marciarocha.movieapp.moviedetail.MovieDetailFragment
import com.marciarocha.movieapp.moviedetail.MovieDetailPresenter
import com.marciarocha.movieapp.moviemain.MovieMainAdapter
import com.marciarocha.movieapp.moviemain.MovieMainContract
import com.marciarocha.movieapp.moviemain.MovieMainPresenter
import dagger.Module
import dagger.Provides

@Module
class MovieDetailFragmentModule {

    @Provides
    fun provideMovieMainPresenter(presenter: MovieDetailPresenter): MovieDetailContract.MovieDetailPresenter = presenter

}