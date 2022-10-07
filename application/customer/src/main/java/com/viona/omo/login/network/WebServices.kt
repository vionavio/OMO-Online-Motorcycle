package com.viona.omo.login.network

import com.viona.omo.login.data.response.*
import com.viona.omo.login.data.response.user.LoginUserResponse
import com.viona.omo.login.data.response.user.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface WebServices {

    @POST(RemoteService.EndPoint.POST_LOGIN_USER)
    suspend fun loginUser(
        @Body body: Map<String, String>
    ): Response<LoginUserResponse>


    @POST(RemoteService.EndPoint.POST_REGISTER_CUSTOMER)
    suspend fun registerCustomer(
        @Body body: Map<String, String>
    ): Response<RegisterCustomerResponse>

    @POST(RemoteService.EndPoint.POST_REGISTER_DRIVER)
    suspend fun registerDriver(
        @Body body: Map<String, String>
    ): Response<RegisterDriverResponse>

    @GET(RemoteService.EndPoint.GET_USER)
    suspend fun getUser(
        @Header("Authorization") token: String
    ): Response<UserResponse>
}