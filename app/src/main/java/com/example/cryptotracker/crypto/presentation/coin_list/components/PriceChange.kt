package com.example.cryptotracker.crypto.presentation.coin_list.components

import android.graphics.LightingColorFilter
import android.provider.Contacts.Intents.UI
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptotracker.crypto.presentation.models.DisplayNumber
import com.example.cryptotracker.ui.theme.CryptoTrackerTheme
import com.example.cryptotracker.ui.theme.errorLight
import com.example.cryptotracker.ui.theme.greenBackground


@Composable
fun PriceChange(
    change: DisplayNumber,
    modifier: Modifier = Modifier,
) {
    // Define colors for positive and negative values
    val contentColor = if (change.value < 0.0) {
        MaterialTheme.colorScheme.onError // Text color for negative values
    } else {
        MaterialTheme.colorScheme.onPrimary // Text color for positive values
    }

    val backgroundColor = if (change.value < 0.0) {
        errorLight // Background for negative values
    } else {
        greenBackground
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(100f))
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 4.dp), // Padding for better spacing
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Arrow Icon indicating direction
        Icon(
            imageVector = if (change.value < 0.0) {
                Icons.Default.KeyboardArrowDown
            } else {
                Icons.Default.KeyboardArrowUp
            },
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = contentColor
        )
        // Percentage change text
        Text(
            text = "${change.formatted} %",
            color = contentColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PriceChangePreviewPositive() {
    CryptoTrackerTheme {
        PriceChange(
            change = DisplayNumber(
                value = 2.43,
                formatted = "2.43"
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PriceChangePreviewNegative() {
    CryptoTrackerTheme {
        PriceChange(
            change = DisplayNumber(
                value = -1.56,
                formatted = "-1.56"
            )
        )
    }
}
