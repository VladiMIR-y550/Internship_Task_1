package com.mironenko.internship_task_1.screens.list

import android.content.Context
import androidx.core.content.edit
import com.mironenko.internship_task_1.InternshipTask1App
import com.mironenko.internship_task_1.PREFERENCE_FILE_KEY
import com.mironenko.internship_task_1.SAVED_ITEM_ID
import com.mironenko.internship_task_1.base.BasePresenterImpl
import com.mironenko.internship_task_1.model.ItemsService

object ItemsListPresenter : BasePresenterImpl<ItemsListContract.View>(),
    ItemsListContract.Presenter {

    override fun getItemsList() {
        view?.showItemsList(ItemsService.getItemsList())
    }

    override fun saveItemIdInPref(itemId: Int) {
        InternshipTask1App.appContext?.getSharedPreferences(
            PREFERENCE_FILE_KEY,
            Context.MODE_PRIVATE
        )?.edit {
            putInt(SAVED_ITEM_ID, itemId)
        }
    }
}