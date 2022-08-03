package com.mironenko.internship_task_1.screens.detail

import com.mironenko.internship_task_1.base.IBasePresenter
import com.mironenko.internship_task_1.base.IBaseView
import com.mironenko.internship_task_1.model.Item

interface IItemDetailContract {

    interface IView : IBaseView {
        fun showItemDetail(item: Item)
    }

    interface IPresenter: IBasePresenter<IView> {
        fun getItemById(itemId: Int)
    }
}