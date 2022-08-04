package com.mironenko.internship_task_1.intent

sealed class ItemDetailIntent {
    class SaveItemIntent(val itemId: Int): ItemsListIntent()
}