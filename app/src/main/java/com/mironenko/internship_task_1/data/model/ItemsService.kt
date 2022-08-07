package com.mironenko.internship_task_1.data.model

object ItemsService {

    private val items by lazy {
        (0..19).map {
            Item(
                id = it,
                name = "Item name $it",
                description = "Item Description $it"
            )
        }
    }

    fun getItemsList(): List<Item> = items

    fun findItemById(itemId: Int): Item = items.first { it.id == itemId }
}