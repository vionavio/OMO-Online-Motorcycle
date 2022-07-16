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
        const val GET_CUSTOMER = "/api/customer"
        const val GET_DRIVER = "/api/driver"
        const val TOKEN_LOGIN_CUSTOMER = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1NTgyMGJmMC1hZmEwLTQ5YWEtYmJhMy03NmQwMmJmZGFiOTciLCJhdXRoIjpbInJlbmF0YSJdLCJleHAiOjE2NTgwMjU2MDN9.BnkMx0V94BVLpHJR8TSAgwbFHcHyfb2Ie5gSc3sWp6I"
        const val TOKEN_LOGIN_DRIVER = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmMDM0YmZlZi0zOTVjLTQxYmItOTAzYS1mMzFmOThlMWQwYzkiLCJhdXRoIjpbImxlbyJdLCJleHAiOjE2NTgwMjY1NTF9.ELRj8sE90JPO0ai_0eNAqNf0Jwaxrns6uiAK_GJl7YM"
    }
}