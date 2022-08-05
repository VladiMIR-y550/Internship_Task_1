package com.mironenko.internship_task_1.viewstate

import com.mironenko.internship_task_1.model.Item

<<<<<<< HEAD
sealed class ItemDetailState {
    object ItemLoadingState : ItemDetailState()
    object NoItemState : ItemDetailState()
    class ItemLoadedState(val item: Item) : ItemDetailState()
}
=======
data class ItemDetailState(
    val isLoading: Boolean,
    val data: Item? = null,
    val errorMessage: String? = null
)
>>>>>>> mvi_mvvm
