package com.viona.omo.network

import com.viona.omo.data.response.LoginCustomerResponse
import com.viona.omo.data.response.LoginDriverResponse
import com.viona.omo.data.response.RegisterCustomerResponse
import com.viona.omo.data.response.RegisterDriverResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

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





}