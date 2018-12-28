package com.marciarocha.movieapp.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V>: BaseContract.IBasePresenter<V> {
    val compositeDisposable = CompositeDisposable()

    override fun removeView() {
        super.removeView()
        compositeDisposable.clear()
    }

}