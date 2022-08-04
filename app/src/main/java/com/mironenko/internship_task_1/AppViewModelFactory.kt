package com.mironenko.internship_task_1

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mironenko.internship_task_1.model.ItemsService
import com.mironenko.internship_task_1.screens.detail.ItemDetailViewModel
import com.mironenko.internship_task_1.screens.list.ItemsListViewModel

class AppViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val sharedPreferences = application.getSharedPreferences(
            PREFERENCE_FILE_KEY,
            Context.MODE_PRIVATE
        )

        val viewModel = when (modelClass) {
            ItemsListViewModel::class.java -> {
                ItemsListViewModel(sharedPreferences, ItemsService)
            }

            ItemDetailViewModel::class.java -> {
                ItemDetailViewModel(ItemsService)
            }
            else -> {
                throw IllegalStateException("Unknown viewModel class")
            }
        }
        return viewModel as T
    }
}

fun Fragment.factory(): AppViewModelFactory =
    AppViewModelFactory(requireContext().applicationContext as InternshipTask1App)