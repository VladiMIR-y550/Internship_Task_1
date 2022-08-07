package com.mironenko.internship_task_1.base

interface Reducer<State, Action> {

    val initialState: State

    fun reduce(state: State, action: Action): State

}