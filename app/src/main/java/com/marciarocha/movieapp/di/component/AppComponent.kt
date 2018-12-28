package com.marciarocha.movieapp.di.component

import android.app.Application
import com.marciarocha.movieapp.MovieApplication
import com.marciarocha.movieapp.di.PerApplication
import com.marciarocha.movieapp.di.module.ActivityBindingsModule
import com.marciarocha.movieapp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@PerApplication
@Component(modules  = [ AndroidSupportInjectionModule::class, AppModule::class, ActivityBindingsModule::class])
interface AppComponent:AndroidInjector<MovieApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun create(app: Application): Builder
        fun build():AppComponent
    }
}