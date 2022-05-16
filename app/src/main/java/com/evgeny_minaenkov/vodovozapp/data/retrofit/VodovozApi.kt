package com.evgeny_minaenkov.vodovozapp.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object VodovozApi {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://szorin.vodovoz.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}