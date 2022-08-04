package com.mironenko.internship_task_1.screens.list

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mironenko.internship_task_1.SAVED_ITEM_ID
import com.mironenko.internship_task_1.intent.ItemsListIntent
import com.mironenko.internship_task_1.model.ItemsService
import com.mironenko.internship_task_1.viewstate.ItemsListState

class ItemsListViewModel(
    private val sharedPreferences: SharedPreferences,
    private val itemService: ItemsService
) : ViewModel() {

    private val _items =
        MutableLiveData<ItemsListState>().apply { postValue(ItemsListState.NoItemsState) }
    val items: LiveData<ItemsListState> = _items

    fun render(intent: ItemsListIntent) {
        when (intent) {
            is ItemsListIntent.ClickedItemIntent -> {
                sharedPreferences.edit {
                    putInt(SAVED_ITEM_ID, intent.itemId)
                }
            }
            is ItemsListIntent.FetchItems -> {
                _items.postValue(ItemsListState.ItemsLoadingState)
                _items.postValue(ItemsListState.ItemsLoadedState(itemService.getItemsList()))
            }
            else -> {
                Log.d(ItemsListViewModel::class.java.simpleName, "Unknown Event")
            }
        }
    }
}