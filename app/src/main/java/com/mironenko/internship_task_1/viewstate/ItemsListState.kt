package com.mironenko.internship_task_1.viewstate

import com.mironenko.internship_task_1.model.Item

sealed class ItemsListState {
    object ItemsLoadingState : ItemsListState()
    object NoItemsState : ItemsListState()
    class ItemsLoadedState(val item: List<Item>) : ItemsListState()
    class ItemsErrorState(val message: String) : ItemsListState()

}