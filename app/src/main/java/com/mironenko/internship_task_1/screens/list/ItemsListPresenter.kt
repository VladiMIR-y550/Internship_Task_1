package com.mironenko.internship_task_1.screens.list
import com.mironenko.internship_task_1.base.BasePresenterImpl
import com.mironenko.internship_task_1.model.ItemsService

object ItemsListPresenter : BasePresenterImpl<ItemsListContract.View>(),
    ItemsListContract.Presenter {

    override fun getItemsList() {
        view?.showItemsList(ItemsService.getItemsList())
    }
}