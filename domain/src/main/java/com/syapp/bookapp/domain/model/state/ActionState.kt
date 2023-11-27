package com.syapp.bookapp.domain.model.state

sealed class ActionState {

    data class Loading(val loadType: LoadType) : ActionState()

    object None : ActionState()

    data class Error(val cause: Throwable?) : ActionState()

    val isContentLoading: Boolean
        get() = this is Loading && loadType == LoadType.CONTENT_LOADING

    val isMoreLoading: Boolean
        get() = this is Loading && loadType == LoadType.MORE_LOADING

    val isError: Boolean
        get() = this is Error
}