package com.mironenko.internship_task_1.intent

sealed class ItemsListIntent {
    object FetchItems : ItemsListIntent()
    class ClickedItemIntent(val itemId: Int): ItemsListIntent()
}