package com.mironenko.internship_task_1.viewstate

import com.mironenko.internship_task_1.model.Item

data class ItemDetailState(
    val isLoading: Boolean,
    val data: Item? = null,
    val errorMessage: String? = null
)
