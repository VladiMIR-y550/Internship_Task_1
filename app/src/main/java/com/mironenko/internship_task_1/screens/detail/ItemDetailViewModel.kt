package com.mironenko.internship_task_1.screens.detail

import com.mironenko.internship_task_1.base.BaseViewModel
import com.mironenko.internship_task_1.base.Interactor

class ItemDetailViewModel(
    interactors: Set<Interactor<ItemDetailState, ItemDetailAction>>,
    itemId: Int
) :
    BaseViewModel<ItemDetailState, ItemDetailAction>(
        interactors = interactors,
        reducer =  ItemDetailReducer(itemId)
    ) {

    fun loadItem() {
        action(ItemDetailAction.LoadItem)
    }
}