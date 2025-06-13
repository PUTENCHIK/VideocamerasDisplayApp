package com.example.videocamerasdisplayapp.network

import com.example.videocamerasdisplayapp.network.requests.CamerasRequest
import com.example.videocamerasdisplayapp.network.requests.ClassRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val BASE_URL = "http://192.168.1.2:5050"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonFactory.gson))
        .build()

    val classes: ClassRequest by lazy {
        retrofit.create(ClassRequest::class.java)
    }

    val cameras: CamerasRequest by lazy {
        retrofit.create(CamerasRequest::class.java)
    }
}