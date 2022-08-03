package com.mironenko.internship_task_1.base

interface IBasePresenter<V : IBaseView> {
    fun attachView(view: V)
    fun detachView()
}