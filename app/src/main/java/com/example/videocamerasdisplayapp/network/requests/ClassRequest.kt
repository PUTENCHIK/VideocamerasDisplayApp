package com.example.videocamerasdisplayapp.network.requests

import com.example.videocamerasdisplayapp.ui.classes.Class
import retrofit2.http.GET

interface ClassRequest {
    @GET("/classes")
    suspend fun get(): List<Class>
}