package com.example.demiurgeshambambukli.presentation.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainButton(
    modifier: Modifier = Modifier, onClick: () -> Unit, title: String
) {
    Button(
        modifier = modifier
        , onClick = { onClick() },
        shape = ShapeDefaults.Small
    ) {
        Text(
            text = title, style = MaterialTheme.typography.labelMedium
        )
    }
}