package com.marciarocha.movieapp.base

import android.os.Bundle
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseFragment<V: BaseContract.IBaseView, P:BaseContract.IBasePresenter<V>> : DaggerFragment(), BaseContract.IBaseView {

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