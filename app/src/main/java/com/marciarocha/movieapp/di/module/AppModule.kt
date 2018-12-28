package com.marciarocha.movieapp.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.marciarocha.movieapp.data.local.MovieDao
import com.marciarocha.movieapp.data.local.MovieDatabase
import com.marciarocha.movieapp.data.remote.RetrofitService
import com.marciarocha.movieapp.di.PerApplication
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    @Provides
    @PerApplication
    fun provideApplicationContext(app: Application): Context = app

    @Provides
    @PerApplication
    internal fun provideRetrofitService(retrofit: Retrofit): RetrofitService = retrofit.create(RetrofitService::class.java)

    @Provides
    @PerApplication
    internal fun retrofit(): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.themoviedb.org/3/")
            .build()

    @Provides
    @PerApplication
    internal fun provideRoomDatabase(application: Application): MovieDatabase = Room.databaseBuilder(application, MovieDatabase::class.java, "movie-db").build()

    @Provides
    @PerApplication
    internal fun provideContentDao(movieDatabase: MovieDatabase): MovieDao = movieDatabase.movieDao()

}
