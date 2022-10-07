package com.viona.omo.login.network

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
        const val POST_LOGIN_USER = "/api/user/login"
        const val POST_REGISTER_CUSTOMER = "/api/user/customer/register"
        const val POST_REGISTER_DRIVER = "/api/user/driver/register"
        const val GET_USER = "/api/user"
        const val TOKEN_LOGIN_USER = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzNDBjYmQxNC0wNmY0LTQwNDItODE3NS0xYzNmYjM3MDU3MGUiLCJhdXRoIjpbImxlbyJdLCJleHAiOjE2NjUyNTQ0NjN9.Yd0nklQAm4JpKl927rIevfx9TqFLLesbrPTWEz9OsQw"
    }
}