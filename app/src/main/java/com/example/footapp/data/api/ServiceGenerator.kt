package com.example.footapp.data.api

import com.example.footapp.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private val client = OkHttpClient.Builder().build()
    private  val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> builsService(service: Class<T>) : T {
        return  retrofit.create(service)
    }
}