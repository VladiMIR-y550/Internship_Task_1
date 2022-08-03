package com.mironenko.internship_task_1.base

abstract class BasePresenter<M, V : IBaseView> : IBasePresenter<V> {

    protected var view: V? = null
    protected var modelData: M? = null

    fun setModel(model: M) {
        this.modelData = model
    }

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }
}