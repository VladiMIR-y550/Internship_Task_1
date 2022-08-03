package com.mironenko.internship_task_1.base

abstract class BasePresenterImpl<V : BaseView> : BasePresenter<V> {

    var view: V? = null
        private set

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }
}