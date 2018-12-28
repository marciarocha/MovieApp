package com.marciarocha.movieapp.di.module

import android.content.Context
import com.marciarocha.movieapp.MovieMainActivity
import com.marciarocha.movieapp.moviemain.MovieMainAdapter
import com.marciarocha.movieapp.moviemain.MovieMainContract
import com.marciarocha.movieapp.moviemain.MovieMainPresenter
import dagger.Module
import dagger.Provides

@Module
class MovieActivityModule {

    @Provides
    fun provideMovieActivityContext(activity: MovieMainActivity):Context = activity

    @Provides
    fun provideMovieMainPresenter(presenter: MovieMainPresenter): MovieMainContract.MovieMainPresenter = presenter

    @Provides
    fun provideMovieMainAdapter(adapter: MovieMainAdapter): MovieMainAdapter = adapter
}