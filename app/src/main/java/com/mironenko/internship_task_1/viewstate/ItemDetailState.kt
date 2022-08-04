package com.mironenko.internship_task_1.viewstate

import com.mironenko.internship_task_1.model.Item

sealed class ItemDetailState {
    object ItemLoadingState : ItemDetailState()
    object NoItemState : ItemDetailState()
    class ItemLoadedState(val item: Item) : ItemDetailState()
}