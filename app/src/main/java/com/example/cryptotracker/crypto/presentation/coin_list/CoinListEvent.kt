package com.example.cryptotracker.crypto.presentation.coin_list

import com.example.cryptotracker.core.domain.util.NetworkError
import org.koin.core.logger.MESSAGE

sealed interface CoinListEvent {
    data class Error(val message: NetworkError): CoinListEvent
}