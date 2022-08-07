package com.mironenko.internship_task_1.screens.list

import com.mironenko.internship_task_1.base.BaseViewModel
import com.mironenko.internship_task_1.base.Interactor

class ItemsListViewModel(
    interactors: Set<Interactor<ItemsListState, ItemsListAction>>
) : BaseViewModel<ItemsListState, ItemsListAction>(
    interactors = interactors,
    reducer = ItemListReducer()
) {
    fun loadItems() {
        action(ItemsListAction.LoadItems)
    }

    fun saveItemId(itemId: Int) {
        action(ItemsListAction.SaveItem(itemId))
    }
}