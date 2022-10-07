package com.viona.omo.login.network

import com.google.gson.Gson
import com.viona.omo.login.data.response.base.BaseResponse
import com.viona.omo.login.data.response.base.ErrorResponse
import com.viona.omo.login.event.StateEvent
import com.viona.omo.login.utils.stringSuspending
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

fun <RequestType : BaseResponse, T> networkHandling(
    callApi: suspend () -> Response<RequestType>,
    processResponse: (response: RequestType?) -> T
): Flow<StateEvent<T>> = flow {
    emit(StateEvent.Loading())


    val emitData = tryToConnect(
        callApi = callApi,
        processResponse = processResponse,
        onSuccess = { data -> StateEvent.Success(data) },
        onError = { error -> StateEvent.Failure(error) }
    )
    emit(emitData)
}

suspend fun <RequestType, T, ResourceType> tryToConnect(
    callApi: suspend () -> Response<RequestType>,
    processResponse: (response: RequestType) -> T,
    onSuccess: (data: T) -> ResourceType,
    onError: (errorResponse: ErrorResponse) -> ResourceType
): ResourceType {

    val resource: ResourceType = try {
        val requestResult = callApi.invoke()
        with(requestResult) {
            when {
                isSuccessful -> {
                    val response = body()
                    val result = processResponse(response!!)
                    onSuccess(result)
                }
                else -> {
                    try {
                        errorBody().let {
                            val errorBody = Gson().fromJson(
                                errorBody()?.stringSuspending(),
                                ErrorResponse::class.java
                            )
                            onError(
                                ErrorResponse(
                                    code(),
                                    errorBody.status,
                                    errorBody.message
                                )
                            )
                        }
                    } catch (e: java.lang.Exception) {
                        onError(ErrorResponse(code()))
                    }
                }
            }
        }
    } catch (e: Exception) {
        onError(
            ErrorResponse(
                null,
                false,
                e.message
            )
        )

    }

    return resource
}