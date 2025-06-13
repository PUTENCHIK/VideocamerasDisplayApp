package com.example.videocamerasdisplayapp.ui.classes

import com.google.gson.annotations.SerializedName
import java.time.OffsetDateTime

data class Class(
    val id: Int,
    val name: String,
    val label: Int,
    val title: String,
    val color: Color,
    @SerializedName("created_at") val createdAt: OffsetDateTime,
    @SerializedName("deleted_at") val deletedAt: OffsetDateTime?
)

data class Color(
    val r: Int,
    val g: Int,
    val b: Int
)