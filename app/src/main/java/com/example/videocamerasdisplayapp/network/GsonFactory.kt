package com.example.videocamerasdisplayapp.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.time.OffsetDateTime

object GsonFactory {
    val gson: Gson = GsonBuilder()
        .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeConverter.serializer)
        .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeConverter.deserializer)
        .create()
}