package com.marciarocha.movieapp.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.LoaderManager
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseActivity<V: BaseContract.IBaseView, P:BaseContract.IBasePresenter<V>> : DaggerAppCompatActivity(), BaseContract.IBaseView {

    @Inject protected lateinit var presenter: P
    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
    }

    override fun onStart() {
        presenter.putView(this as V)
        super.onStart()
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }


}