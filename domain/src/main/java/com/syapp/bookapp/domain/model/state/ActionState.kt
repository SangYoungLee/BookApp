package com.syapp.bookapp.domain.model.state

sealed interface ActionState {

    data class Loading(val loadType: LoadType) : ActionState

    object None : ActionState

    data class Error(val cause: Throwable?) : ActionState
}