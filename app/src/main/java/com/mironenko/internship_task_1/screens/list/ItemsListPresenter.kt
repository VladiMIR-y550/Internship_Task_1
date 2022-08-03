package com.mironenko.internship_task_1.screens.list

import com.mironenko.internship_task_1.base.BasePresenter
import com.mironenko.internship_task_1.model.ItemsService

object ItemsListPresenter : BasePresenter<ItemsService, IItemsListContract.IView>(),
    IItemsListContract.IPresenter {

    init {
        setModel(ItemsService)
    }

    override fun getItemsList() {
        modelData?.getItemsList()?.let { view?.showItemsList(it) }
    }
}