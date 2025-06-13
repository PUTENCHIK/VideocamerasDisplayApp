package com.example.videocamerasdisplayapp.ui.common

import java.time.format.DateTimeFormatter

object DTFormatter {
    private const val format = "dd.MM.yyyy HH:mm:ss"

    val formatter = DateTimeFormatter.ofPattern(format)
}