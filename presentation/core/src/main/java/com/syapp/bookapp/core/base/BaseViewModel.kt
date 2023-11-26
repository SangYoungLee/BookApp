package com.syapp.styleapp.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<VS: ViewState, SE: ViewSideEffect, VE: ViewEvent>(
    initialState: VS
) : ViewModel() {

    private val _viewState = MutableStateFlow(initialState)
    val viewState = _viewState.asStateFlow()

    private val _sideEffect = Channel<SE>()
    val sideEffect = _sideEffect.receiveAsFlow()

    val currentViewState: VS
        get() = viewState.value

    protected fun updateState(reducer: VS.() -> VS) {
        val newState = currentViewState.reducer()
        _viewState.value = newState
    }

    protected fun sendSideEffect(sideEffect: SE) {
        viewModelScope.launch {
            _sideEffect.send(sideEffect)
        }
    }

    fun setViewEvent(viewEvent: VE) {
        handleViewEvent(viewEvent)
    }

    protected open fun handleViewEvent(viewEvent: VE) {

    }
}