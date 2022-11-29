package com.bignerdranch.android.composeproject.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(25.dp,25.dp,0.dp,0.dp),
    large = RoundedCornerShape(25.dp,0.dp,25.dp,0.dp)
)