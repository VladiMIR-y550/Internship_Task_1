package com.mironenko.internship_task_1.viewstate

import com.mironenko.internship_task_1.model.Item

data class ItemsListState(
    val isLoading: Boolean,
    val data: List<Item>?,
    val errorMessage: String? = null
)
