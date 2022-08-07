package com.mironenko.internship_task_1.screens.list

import com.mironenko.internship_task_1.base.Reducer

class ItemListReducer : Reducer<ItemsListState, ItemsListAction> {

    override val initialState = ItemsListState(
        items = listOf()
    )

    override fun reduce(state: ItemsListState, action: ItemsListAction): ItemsListState {
        return when (action) {
            ItemsListAction.None -> state
            ItemsListAction.LoadItems -> state
            is ItemsListAction.ItemsLoaded -> state.copy(
                items = action.items
            )
            is ItemsListAction.SaveItem -> state
            ItemsListAction.ItemSaved -> state
            is ItemsListAction.Error -> state
        }
    }
}