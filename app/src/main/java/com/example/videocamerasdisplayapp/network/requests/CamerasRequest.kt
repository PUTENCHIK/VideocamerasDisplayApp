package com.example.videocamerasdisplayapp.network.requests

import com.example.videocamerasdisplayapp.ui.cameras.Camera
import retrofit2.http.GET

interface CamerasRequest {
    @GET("/cameras")
    suspend fun get(): List<Camera>
}