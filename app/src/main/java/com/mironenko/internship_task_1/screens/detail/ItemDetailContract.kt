package com.mironenko.internship_task_1.screens.detail

import com.mironenko.internship_task_1.base.BasePresenter
import com.mironenko.internship_task_1.base.BaseView
import com.mironenko.internship_task_1.model.Item

interface ItemDetailContract {

    interface View : BaseView {
        fun showItemDetail(item: Item)
    }

    interface Presenter : BasePresenter<View> {
        fun getItemById(itemId: Int)
    }
}