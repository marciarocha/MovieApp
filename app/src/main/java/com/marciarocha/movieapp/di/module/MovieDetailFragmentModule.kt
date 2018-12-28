package com.marciarocha.movieapp.di.module


import com.marciarocha.movieapp.moviedetail.MovieDetailContract
import com.marciarocha.movieapp.moviedetail.MovieDetailPresenter
import dagger.Module
import dagger.Provides

@Module
class MovieDetailFragmentModule {

    @Provides
    fun provideMovieMainPresenter(presenter: MovieDetailPresenter): MovieDetailContract.MovieDetailPresenter = presenter

}