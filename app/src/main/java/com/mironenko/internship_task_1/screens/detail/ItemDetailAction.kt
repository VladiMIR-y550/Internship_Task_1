package com.mironenko.internship_task_1.screens.detail

import com.mironenko.internship_task_1.data.model.Item

sealed class ItemDetailAction {

    object None : ItemDetailAction()
    object LoadItem : ItemDetailAction()
    data class ItemLoaded(val item: Item) : ItemDetailAction()
    data class Error(val exception: Exception) : ItemDetailAction()
}