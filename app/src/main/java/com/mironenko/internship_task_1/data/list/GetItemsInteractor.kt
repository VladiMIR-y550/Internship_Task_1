package com.mironenko.internship_task_1.data.list

import android.content.SharedPreferences
import androidx.core.content.edit
import com.mironenko.internship_task_1.base.Interactor
import com.mironenko.internship_task_1.data.model.ItemsService
import com.mironenko.internship_task_1.screens.list.ItemsListAction
import com.mironenko.internship_task_1.screens.list.ItemsListState
import com.mironenko.internship_task_1.util.SAVED_ITEM_ID

class GetItemsInteractor(private val sharedPreferences: SharedPreferences) :
    Interactor<ItemsListState, ItemsListAction> {
    override fun invoke(state: ItemsListState, action: ItemsListAction): ItemsListAction {
        return when (action) {
            is ItemsListAction.LoadItems -> {
                ItemsListAction.ItemsLoaded(ItemsService.getItemsList())
            }
            is ItemsListAction.SaveItem -> {
                saveInSharedPref(action.itemId)
                ItemsListAction.ItemSaved
            }
            is ItemsListAction.Error -> ItemsListAction.Error(
                IllegalArgumentException(
                    "Wrong action: $action"
                )
            )
            else -> {
                ItemsListAction.None
            }
        }
    }

    private fun saveInSharedPref(itemId: Int) {
        sharedPreferences.edit {
            putInt(SAVED_ITEM_ID, itemId)
        }
    }

    override fun canHandle(action: ItemsListAction): Boolean {
        return when (action) {
            ItemsListAction.LoadItems -> true
            is ItemsListAction.SaveItem -> true
            else -> false
        }
    }
}