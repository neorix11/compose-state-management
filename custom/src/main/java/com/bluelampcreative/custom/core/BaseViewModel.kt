package com.bluelampcreative.custom.core

import androidx.lifecycle.ViewModel
import com.bluelampcreative.custom.ui.state.IStateReducer

abstract class BaseViewModel<T>: ViewModel() {
    abstract val state: IStateReducer<T, Any>
    abstract fun reduceState(currentState: T, action: Any): T
}