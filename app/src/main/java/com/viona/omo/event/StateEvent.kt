package com.viona.omo.event

import com.viona.omo.data.response.base.ErrorResponse

sealed class StateEvent<T> {
    class Idle<T> : StateEvent<T>()
    class Loading<T> : StateEvent<T>()
    data class Success<T>(val data: T) : StateEvent<T>()
    data class Failure<T>(val exception: ErrorResponse) : StateEvent<T>()
}