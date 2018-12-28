package com.marciarocha.movieapp.base

interface BaseContract {

    interface IBaseView

    interface IBasePresenter<T> {
        var view: T?

        fun putView(view: T){
            this.view = view
        }

        fun removeView() {
            view = null
        }

    }


}