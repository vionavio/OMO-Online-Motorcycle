package com.viona.omo.login.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viona.omo.login.event.MutableStateEventManager
import com.viona.omo.login.event.StateEvent
import com.viona.omo.login.event.StateEventManager
import com.viona.omo.login.event.StateEventSubscriber
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody

typealias FlowState<T> = Flow<StateEvent<T>>

fun <T> default() = MutableStateEventManager<T>()

fun <T> ViewModel.convertEventToSubscriber(
    eventManager: StateEventManager<T>,
    subscriber: StateEventSubscriber<T>
) {
    eventManager.subscribe(
        scope = viewModelScope,
        onIdle = subscriber::onIdle,
        onLoading = subscriber::onLoading,
        onFailure = subscriber::onFailure,
        onSuccess = subscriber::onSuccess
    )
}

suspend fun ResponseBody.stringSuspending(): String = withContext(Dispatchers.IO) { run(::string) }


