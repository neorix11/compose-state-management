package com.bluelampcreative.domain.state

sealed class LoadingState {
    object Idle: LoadingState()
    object Loading: LoadingState()
    object Loaded: LoadingState()
    data class Error(val error: String): LoadingState()
}