package com.mironenko.internship_task_1.screens.list

import com.mironenko.internship_task_1.data.model.Item

sealed class ItemsListAction {
    object None : ItemsListAction()
    object LoadItems : ItemsListAction()
    object ItemSaved : ItemsListAction()
    data class SaveItem(val itemId: Int) : ItemsListAction()
    data class ItemsLoaded(val items: List<Item>) : ItemsListAction()
    data class Error(val exception: Exception) : ItemsListAction()
}