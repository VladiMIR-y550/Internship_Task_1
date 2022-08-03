package com.mironenko.internship_task_1.screens.list

import com.mironenko.internship_task_1.base.BasePresenter
import com.mironenko.internship_task_1.base.BaseView
import com.mironenko.internship_task_1.model.Item

interface ItemsListContract {

    interface View : BaseView {
        fun showItemsList(items: List<Item>)
    }

    interface Presenter : BasePresenter<View> {
        fun getItemsList()
    }
}