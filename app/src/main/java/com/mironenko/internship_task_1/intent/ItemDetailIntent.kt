package com.mironenko.internship_task_1.intent

sealed class ItemDetailIntent {
    class LoadItemIntent(val itemId: Int) : ItemsListIntent()
}