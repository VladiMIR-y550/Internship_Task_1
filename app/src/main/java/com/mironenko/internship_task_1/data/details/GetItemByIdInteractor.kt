package com.mironenko.internship_task_1.data.details

import com.mironenko.internship_task_1.base.Interactor
import com.mironenko.internship_task_1.data.model.ItemsService
import com.mironenko.internship_task_1.screens.detail.ItemDetailAction
import com.mironenko.internship_task_1.screens.detail.ItemDetailState

class GetItemByIdInteractor : Interactor<ItemDetailState, ItemDetailAction> {
    override fun invoke(
        state: ItemDetailState,
        action: ItemDetailAction
    ): ItemDetailAction {
        return if (action is ItemDetailAction.LoadItem) {
            ItemDetailAction.ItemLoaded(ItemsService.findItemById(state.itemId))
        } else {
            ItemDetailAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: ItemDetailAction): Boolean {
        return action is ItemDetailAction.LoadItem
    }
}