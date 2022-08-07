package com.mironenko.internship_task_1.util

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mironenko.internship_task_1.InternshipTask1App
import com.mironenko.internship_task_1.PREFERENCE_FILE_KEY
import com.mironenko.internship_task_1.data.details.GetItemByIdInteractor
import com.mironenko.internship_task_1.data.list.GetItemsInteractor
import com.mironenko.internship_task_1.screens.detail.ItemDetailViewModel
import com.mironenko.internship_task_1.screens.list.ItemsListViewModel

class AppViewModelFactory(private val application: Application, private val itemId: Int) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val sharedPreferences = application.getSharedPreferences(
            PREFERENCE_FILE_KEY,
            Context.MODE_PRIVATE
        )

        val viewModel = when (modelClass) {
            ItemsListViewModel::class.java -> {
                ItemsListViewModel(
                    interactors = setOf(
                        GetItemsInteractor(sharedPreferences)
                    )
                )
            }

            ItemDetailViewModel::class.java -> {
                ItemDetailViewModel(
                    interactors = setOf(
                        GetItemByIdInteractor()
                    ), itemId = itemId
                )
            }
            else -> {
                throw IllegalStateException("Unknown viewModel class")
            }
        }
        return viewModel as T
    }
}

fun Fragment.factory(itemId: Int = -1): AppViewModelFactory =
    AppViewModelFactory(requireContext().applicationContext as InternshipTask1App, itemId = itemId)