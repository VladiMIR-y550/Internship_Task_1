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

    fun getItemById(itemId: Int): Item? {
        val indexFoundElement = items.indexOfFirst { it.id == itemId }
        return if (indexFoundElement == -1) null
        else items[indexFoundElement]
    }
}