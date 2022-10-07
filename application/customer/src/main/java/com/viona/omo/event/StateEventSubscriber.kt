package com.viona.omo.event

import com.viona.omo.data.response.base.ErrorResponse

interface StateEventSubscriber<T> {
    fun onIdle()
    fun onLoading()
    fun onFailure(throwable: ErrorResponse)
    fun onSuccess(data: T)
}