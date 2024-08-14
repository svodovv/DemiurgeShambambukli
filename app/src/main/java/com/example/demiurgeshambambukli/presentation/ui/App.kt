package com.example.demiurgeshambambukli.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.demiurgeshambambukli.R
import com.example.demiurgeshambambukli.presentation.ui.components.MainTopAppBar
import com.example.demiurgeshambambukli.presentation.ui.screens.cellular.CellularFillingScreen
import com.example.demiurgeshambambukli.presentation.ui.theme.DemiurgeShambambukliTheme

@Composable
fun App() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { MainTopAppBar(stringResource(R.string.cellular_filling)) }) { paddingValues ->
        CellularFillingScreen(paddingValues = paddingValues)
    }
}


@Composable
@Preview
fun AppPreview() {
    DemiurgeShambambukliTheme {
        App()
    }
}