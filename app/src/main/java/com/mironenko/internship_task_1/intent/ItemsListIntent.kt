package com.mironenko.internship_task_1.intent

sealed class ItemsListIntent {
    object FetchItemsIntent : ItemsListIntent()
    class SaveItemIntent(val itemId: Int) : ItemsListIntent()
}