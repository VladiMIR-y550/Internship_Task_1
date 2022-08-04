package com.mironenko.internship_task_1.screens.list

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mironenko.internship_task_1.SAVED_ITEM_ID
import com.mironenko.internship_task_1.model.Item
import com.mironenko.internship_task_1.model.ItemsService

class ItemsListViewModel(
    private val sharedPreferences: SharedPreferences,
    itemService: ItemsService
) :
    ViewModel() {

    private val _items =
        MutableLiveData<List<Item>>().apply { postValue(itemService.getItemsList()) }
    val items: LiveData<List<Item>> = _items

    fun saveItemIdInPref(itemId: Int) {
        sharedPreferences.edit {
            putInt(SAVED_ITEM_ID, itemId)
        }
    }
}