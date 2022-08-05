package com.mironenko.internship_task_1.intent

sealed class ItemsListIntent {
<<<<<<< HEAD
    object FetchItems : ItemsListIntent()
    class ClickedItemIntent(val itemId: Int): ItemsListIntent()
=======
    object FetchItemsIntent : ItemsListIntent()
    class SaveItemIntent(val itemId: Int): ItemsListIntent()
>>>>>>> mvi_mvvm
}