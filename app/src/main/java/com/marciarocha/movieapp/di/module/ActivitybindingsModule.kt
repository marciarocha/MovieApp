package com.marciarocha.movieapp.di.module

import com.marciarocha.movieapp.MovieMainActivity
import com.marciarocha.movieapp.di.PerActivity
import com.marciarocha.movieapp.moviedetail.MovieDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingsModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MovieActivityModule::class])
    abstract fun bindMovieMainActivity(): MovieMainActivity


    @ContributesAndroidInjector(modules=[MovieDetailFragmentModule::class])
    abstract fun bindMovieDetailFragment(): MovieDetailFragment


}