package com.viona.omo.login.event

import com.viona.omo.login.data.response.base.ErrorResponse

interface StateEventSubscriber<T> {
    fun onIdle()
    fun onLoading()
    fun onFailure(throwable: ErrorResponse)
    fun onSuccess(data: T)
}