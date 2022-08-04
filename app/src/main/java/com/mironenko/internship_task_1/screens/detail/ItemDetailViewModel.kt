package com.mironenko.internship_task_1.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mironenko.internship_task_1.model.Item
import com.mironenko.internship_task_1.model.ItemsService

class ItemDetailViewModel(private val itemService: ItemsService) :
    ViewModel() {

    private val _item = MutableLiveData<Item>()
    val item: LiveData<Item> = _item

    fun getItemById(itemId: Int) {
        itemService.findItemById(itemId).let { _item.postValue(it) }
    }
}