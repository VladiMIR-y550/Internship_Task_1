package com.mironenko.internship_task_1.base

interface Interactor<State, Action> {

    fun invoke(state: State, action: Action): Action

    fun canHandle(action: Action): Boolean
}