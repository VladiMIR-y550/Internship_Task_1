package com.mironenko.internship_task_1.base

interface BasePresenter<V : BaseView> {
    fun attachView(view: V)
    fun detachView()
}