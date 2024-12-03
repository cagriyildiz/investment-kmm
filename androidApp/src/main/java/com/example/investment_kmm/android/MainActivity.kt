package com.example.investment_kmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingView({ viewModel.getCurrentPrice() }, viewModel.uiState)
                }
            }
        }
    }
}

@Composable
fun GreetingView(onButtonClick: () -> Unit, uiState: MainActivityUiState) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(modifier = Modifier.height(50.dp).fillMaxWidth(), onClick = onButtonClick) {
            Text("Get current price")
        }

        Spacer(Modifier.height(15.dp))

        Text(text = uiState.currentPrice ?: uiState.errorMessage ?: "", Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView(
            onButtonClick = {},
            uiState = MainActivityUiState()
        )
    }
}
