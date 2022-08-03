package com.mironenko.internship_task_1.screens.detail

import com.mironenko.internship_task_1.DEFAULT_VALUE
import com.mironenko.internship_task_1.base.BasePresenter
import com.mironenko.internship_task_1.model.ItemsService

object ItemDetailPresenter : BasePresenter<ItemsService, IItemDetailContract.IView>(),
    IItemDetailContract.IPresenter {
    private var itemId = DEFAULT_VALUE

    init {
        setModel(ItemsService)
    }

    override fun getItemById(itemId: Int) {
        this.itemId = itemId
        modelData?.findItemById(itemId)?.let { view?.showItemDetail(it) }
    }
}