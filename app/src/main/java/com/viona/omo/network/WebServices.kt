package com.viona.omo.network

import com.viona.omo.data.response.*
import retrofit2.Response
import retrofit2.http.*

interface WebServices {

    @POST(RemoteService.EndPoint.POST_LOGIN_CUSTOMER)
    suspend fun loginCustomer(
        @Body body: Map<String, String>
    ): Response<LoginCustomerResponse>


    @POST(RemoteService.EndPoint.POST_LOGIN_DRIVER)
    suspend fun loginDriver(
        @Body body: Map<String, String>
    ): Response<LoginDriverResponse>

    @POST(RemoteService.EndPoint.POST_REGISTER_CUSTOMER)
    suspend fun registerCustomer(
        @Body body: Map<String, String>
    ): Response<RegisterCustomerResponse>

    @POST(RemoteService.EndPoint.POST_REGISTER_DRIVER)
    suspend fun registerDriver(
        @Body body: Map<String, String>
    ): Response<RegisterDriverResponse>

    @GET(RemoteService.EndPoint.GET_CUSTOMER)
    suspend fun getCustomer(
        @Header("Authorization") token: String
    ): Response<CustomerResponse>

    @GET(RemoteService.EndPoint.GET_DRIVER)
    suspend fun getDriver(
        @Header("Authorization") token: String
    ): Response<DriverResponse>
}