package com.mironenko.internship_task_1.intent

sealed class ItemDetailIntent {
<<<<<<< HEAD
    class SaveItemIntent(val itemId: Int): ItemsListIntent()
=======
    class LoadItemIntent(val itemId: Int): ItemsListIntent()
>>>>>>> mvi_mvvm
}