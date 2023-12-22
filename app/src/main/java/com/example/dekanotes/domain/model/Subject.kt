package com.example.dekanotes.domain.model

import androidx.compose.ui.graphics.Color

data class Subject(
    val name : String,
    val goalHour: Float,
    val colors : List<Color>
)
