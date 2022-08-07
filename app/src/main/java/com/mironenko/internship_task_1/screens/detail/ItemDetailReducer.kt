package com.mironenko.internship_task_1.screens.detail

import com.mironenko.internship_task_1.base.Reducer

class ItemDetailReducer(itemId: Int) : Reducer<ItemDetailState, ItemDetailAction> {

    override val initialState = ItemDetailState(
        itemId = itemId,
        item = null
    )

    override fun reduce(state: ItemDetailState, action: ItemDetailAction): ItemDetailState {
        return when (action) {
            ItemDetailAction.None -> state
            ItemDetailAction.LoadItem -> state
            is ItemDetailAction.ItemLoaded -> state.copy(
                item = action.item
            )
            is ItemDetailAction.Error -> state
        }
    }
}