package com.example.cryptotracker.crypto.presentation.coin_detail

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

data class ChartStyle(
    val chartLineColor: Color,
    val unselectedColor: Color,
    val selectecColor: Color,
    val hyperLinesThicknessPx: Float,
    val axisLineThicknessPx: Float,
    val lableFontSize: TextUnit,
    val minYLableSpacing: Dp,
    val verticalPadding: Dp,
    val horizantalPadding:Dp,
    val xAxisLableSpacing: Dp
    )