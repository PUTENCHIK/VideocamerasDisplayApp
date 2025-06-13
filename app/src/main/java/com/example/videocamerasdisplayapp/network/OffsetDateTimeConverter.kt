package com.example.videocamerasdisplayapp.network

import com.google.gson.JsonDeserializer
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializer
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

object OffsetDateTimeConverter {
    private val datetimeFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS"
    private val formatter = DateTimeFormatter.ofPattern(datetimeFormat).withZone(ZoneOffset.UTC)

    val serializer = JsonSerializer<OffsetDateTime> { src, _, _ ->
        JsonPrimitive(formatter.format(src))
    }

    val deserializer = JsonDeserializer<OffsetDateTime> { json, _, _ ->
        OffsetDateTime.parse(json.asString, formatter)
    }
}