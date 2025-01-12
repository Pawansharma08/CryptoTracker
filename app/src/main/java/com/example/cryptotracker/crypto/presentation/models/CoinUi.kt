package com.example.cryptotracker.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.example.cryptotracker.crypto.domain.Coin
import com.example.cryptotracker.core.presentation.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

data class CoinUi(
    val id : String,
    val rank : Int,
    val name : String,
    val symbol: String,
    val marketCapUsd: DisplayNumber,
    val priceUsd : DisplayNumber,
    val changePercent24Hr : DisplayNumber,
    @DrawableRes val iconRes : Int

)

data class DisplayNumber(
    val value : Double,
    val formatted: String
)

fun Coin.toCoinUi(): CoinUi{
    return CoinUi(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDisplayNumber(),
        marketCapUsd = marketCapUsd.toDisplayNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayNumber(),
        iconRes =  getDrawableIdForCoin(symbol)
    )
}


fun Double.toDisplayNumber(): DisplayNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayNumber(
        value = this,
        formatted = formatter.format(this)
    )
}