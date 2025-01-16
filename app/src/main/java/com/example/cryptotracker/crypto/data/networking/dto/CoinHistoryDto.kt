package com.example.cryptotracker.crypto.data.networking.dto

import com.example.cryptotracker.core.domain.util.NetworkError
import com.example.cryptotracker.crypto.domain.CoinPrice
import kotlinx.serialization.Serializable
import java.time.ZonedDateTime

@Serializable
data class CoinHistoryDto(
    val data : List<CoinPriceDto>
)
