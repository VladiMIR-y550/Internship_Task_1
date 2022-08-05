package com.mironenko.internship_task_1.screens.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mironenko.internship_task_1.intent.ItemDetailIntent
import com.mironenko.internship_task_1.intent.ItemsListIntent
import com.mironenko.internship_task_1.model.ItemsService
import com.mironenko.internship_task_1.viewstate.ItemDetailState

class ItemDetailViewModel(private val itemService: ItemsService) :
    ViewModel() {

    private val _item =
        MutableLiveData<ItemDetailState>().apply {
            postValue(
                ItemDetailState(
                    isLoading = true,
                    data = null
                )
            )
        }
    val item: LiveData<ItemDetailState> = _item

    fun getItemById(itemId: Int) {
        intentHandler(ItemDetailIntent.LoadItemIntent(itemId))
    }

    private fun intentHandler(event: ItemsListIntent) {
        when (event) {
            is ItemDetailIntent.LoadItemIntent -> {
                _item.postValue(ItemDetailState(isLoading = true))
                itemService.findItemById(event.itemId)
                    ?.let { _item.postValue(ItemDetailState(isLoading = false, data = it)) }
            }
            else -> {
                Log.d(ItemDetailViewModel::class.java.simpleName, "Unknown Event")
            }
        }
    }
}