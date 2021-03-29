package com.example.kotlinbottomnavsample.data.remote.api

import com.example.kotlinbottomnavsample.data.remote.interfaces.UserEndpoints
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://aliakbar-ghasemi.ir/api/"

    private val client = OkHttpClient
        .Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private fun<T> buildService (service : Class <T>) : T {
        return  retrofit.create(service)
    }

    fun getUserService(): UserEndpoints {
        return buildService(UserEndpoints::class.java)
    }
}