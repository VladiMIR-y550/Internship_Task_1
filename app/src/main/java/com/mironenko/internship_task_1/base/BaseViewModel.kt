package com.mironenko.internship_task_1.base

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mironenko.internship_task_1.util.delegate

abstract class BaseViewModel<State, Action>(
    private val interactors: Set<Interactor<State, Action>>,
    private val reducer: Reducer<State, Action>
) : ViewModel() {

    private val mutableState = MutableLiveData(reducer.initialState)
    private var stateValue by mutableState.delegate()
    val state: LiveData<State> = mutableState

    @MainThread
    protected fun action(action: Action) {
        stateValue = reducer.reduce(stateValue, action)
        interactors.filter { it.canHandle(action) }.forEach { interactor ->
            val result = interactor.invoke(stateValue, action)
            action(result)
        }
    }
}