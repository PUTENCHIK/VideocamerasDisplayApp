package com.example.videocamerasdisplayapp.ui.cameras

import com.google.gson.annotations.SerializedName
import java.time.OffsetDateTime

data class Camera(
    val id: Int,
    val address: String,
    @SerializedName("is_monitoring") val isMonitoring: Boolean,
    @SerializedName("created_at") val createdAt: OffsetDateTime,
    @SerializedName("deleted_at") val deletedAt: OffsetDateTime?
)