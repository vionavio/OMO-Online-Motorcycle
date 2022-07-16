package com.viona.omo.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RemoteService {

    companion object {
        private const val BASE_URL = "https://omo-online-motorcycle-api.herokuapp.com/"


        fun build(): WebServices {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WebServices::class.java)
        }
    }

    object EndPoint {
        const val POST_LOGIN_CUSTOMER = "/api/customer/login"
        const val POST_LOGIN_DRIVER = "/api/driver/login"
        const val POST_REGISTER_CUSTOMER = "/api/customer/register"
        const val POST_REGISTER_DRIVER = "/api/driver/register"
    }
}