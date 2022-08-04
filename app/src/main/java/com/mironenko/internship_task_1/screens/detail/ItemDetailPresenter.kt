package com.mironenko.internship_task_1.screens.detail

import com.mironenko.internship_task_1.DEFAULT_VALUE
import com.mironenko.internship_task_1.base.BasePresenterImpl
import com.mironenko.internship_task_1.model.ItemsService

class ItemDetailPresenter : BasePresenterImpl<ItemDetailContract.View>(),
    ItemDetailContract.Presenter {
    private var itemId = DEFAULT_VALUE

    override fun getItemById(itemId: Int) {
        this.itemId = itemId
        ItemsService.findItemById(itemId)?.let { view?.showItemDetail(it) }
    }
}