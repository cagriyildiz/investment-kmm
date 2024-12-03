package com.example.investment_kmm.android

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.investment_kmm.common.util.Result
import com.example.investment_kmm.end_of_day.domain.usecase.GetCurrentPriceUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel(
    val getCurrentPriceUseCase: GetCurrentPriceUseCase
) : ViewModel() {
    var uiState: MainActivityUiState by mutableStateOf(MainActivityUiState())
        private set

    fun getCurrentPrice() {
        viewModelScope.launch{
            val result = getCurrentPriceUseCase(ticker = "aapl")

            uiState = when (result) {
                is Result.Error -> {
                    uiState.copy(
                        errorMessage = result.message
                    )
                }

                is Result.Success -> {
                    uiState.copy(
                        currentPrice = result.data?.first()?.high.toString()
                    )
                }
            }
        }
    }
}

data class MainActivityUiState(
    var currentPrice: String? = null,
    var errorMessage: String? = null
)
