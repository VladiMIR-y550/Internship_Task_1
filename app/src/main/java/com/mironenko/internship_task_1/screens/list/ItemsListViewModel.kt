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

    private val _items: MutableLiveData<ItemsListState> =
        MutableLiveData<ItemsListState>().apply {
            postValue(
                ItemsListState(
                    isLoading = false,
                    data = null
                )
            )
        }
    val items: LiveData<ItemsListState> = _items

    init {
        intentHandler(ItemsListIntent.FetchItemsIntent)
    }

    fun saveItemId(itemId: Int) {
        intentHandler(ItemsListIntent.SaveItemIntent(itemId))
    }

    private fun intentHandler(intent: ItemsListIntent) {
        when (intent) {
            is ItemsListIntent.SaveItemIntent -> {
                sharedPreferences.edit {
                    putInt(SAVED_ITEM_ID, intent.itemId)
                }
            }

            is ItemsListIntent.FetchItemsIntent -> {
                _items.postValue(
                    try {
                        ItemsListState(
                            isLoading = false,
                            data = itemService.getItemsList()
                        )
                    } catch (e: Exception) {
                        ItemsListState(
                            isLoading = true,
                            data = null,
                            errorMessage = e.message
                        )
                    }
                )
            }
            else -> {
                Log.d(ItemsListViewModel::class.java.simpleName, "Unknown Event")
            }
        }
    }
}