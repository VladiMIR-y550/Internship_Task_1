package com.mironenko.internship_task_1.model

object ItemsService {

    private val items = (0..19).map {
        Item(
            id = it,
            name = "Item name $it",
            description = "Item Description $it"
        )
    }

    fun getItemsList(): List<Item> = items

    fun getItemById(itemId: Int) = items.find { it.id == itemId }
}