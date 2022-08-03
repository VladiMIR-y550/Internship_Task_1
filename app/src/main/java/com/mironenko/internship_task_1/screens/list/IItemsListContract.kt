package com.mironenko.internship_task_1.screens.list

import com.mironenko.internship_task_1.base.IBasePresenter
import com.mironenko.internship_task_1.base.IBaseView
import com.mironenko.internship_task_1.model.Item

interface IItemsListContract {

    interface IView : IBaseView {
        fun showItemsList(items: List<Item>)
    }

    interface IPresenter : IBasePresenter<IView> {
        fun getItemsList()
    }
}