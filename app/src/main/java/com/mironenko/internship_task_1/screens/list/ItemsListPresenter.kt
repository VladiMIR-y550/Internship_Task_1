package com.mironenko.internship_task_1.screens.list

import android.content.SharedPreferences
import androidx.core.content.edit
import com.mironenko.internship_task_1.SAVED_ITEM_ID
import com.mironenko.internship_task_1.base.BasePresenterImpl
import com.mironenko.internship_task_1.model.ItemsService

class ItemsListPresenter(private val sharedPreferences: SharedPreferences) :
    BasePresenterImpl<ItemsListContract.View>(),
    ItemsListContract.Presenter {

    override fun getItemsList() {
        view?.showItemsList(ItemsService.getItemsList())
    }

    override fun saveItemIdInPref(itemId: Int) {
        sharedPreferences.edit {
            putInt(SAVED_ITEM_ID, itemId)
        }
    }
}