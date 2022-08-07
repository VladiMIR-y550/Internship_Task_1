package com.mironenko.internship_task_1.screens.detail

import com.mironenko.internship_task_1.data.model.Item

data class ItemDetailState(
    val itemId: Int,
    val item: Item?
)
