package com.example.demiurgeshambambukli.presentation.ui.screens.cellular

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.demiurgeshambambukli.R
import com.example.demiurgeshambambukli.presentation.domain.model.cellilar.CellularModel
import com.example.demiurgeshambambukli.presentation.domain.model.cellilar.CellularModelState
import com.example.demiurgeshambambukli.presentation.ui.components.MainButton
import com.example.demiurgeshambambukli.presentation.ui.theme.DemiurgeShambambukliTheme

@Composable
fun CellularFillingScreen(
    paddingValues: PaddingValues, viewModel: CellularFillingViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(key1 = state.cellularList.size) {
        listState.animateScrollToItem(state.cellularList.size)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary, Color.Black, Color.Black
                    )
                )
            )
    ) {

        CellularFillingContent(
            modifier = Modifier.padding(bottom = 64.dp),
            cellularList = state.cellularList,
            listState = listState
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.BottomCenter
        ) {
            MainButton(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), onClick = {
                viewModel.sendIntent(CellularFillingIntent.GenerateCellular)
            }, title = stringResource(R.string.ceat_cellular))
        }
    }
}

@Composable
private fun CellularFillingContent(
    modifier: Modifier = Modifier, cellularList: List<CellularModel>, listState: LazyListState
) {

    LazyColumn(
        modifier = modifier
            .padding(top = 8.dp)
            .padding(horizontal = 16.dp), state = listState
    ) {
        items(cellularList) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .size(50.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(getIconBackgroundColor(it.state))
                            , contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = it.imageUrl,
                            contentDescription = it.title,
                            modifier = Modifier.size(30.dp),
                            placeholder = painterResource(id = R.drawable.round_hourglass_bottom_24),
                            error = painterResource(id = R.drawable.baseline_error_outline_24),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Column(modifier = Modifier.fillMaxHeight()) {
                        Text(text = it.title, style = MaterialTheme.typography.headlineMedium)
                        Text(text = it.description, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}



@Composable
private fun getIconBackgroundColor(state: CellularModelState): Brush {
    when (state) {
        CellularModelState.Alive -> {
            return Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.onTertiaryContainer, MaterialTheme.colorScheme.surface
                )
            )
        }

        CellularModelState.Dead -> {
            return Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.secondaryContainer,
                    MaterialTheme.colorScheme.surface
                )
            )
        }

        CellularModelState.Death -> {
            return Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.surface,
                    MaterialTheme.colorScheme.onSecondaryContainer,
                )
            )
        }

        CellularModelState.Life -> {
            return Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.surface
                )
            )
        }
    }
}

@Composable
@Preview
fun CellularFillingContentPreview() {

    val cellularList = listOf(
        CellularModel(
            title = "Живая",
            description = "и шивелиться!",
            imageUrl = "",
            state = CellularModelState.Life
        )
    )
    DemiurgeShambambukliTheme {
        CellularFillingContent(cellularList = cellularList, listState = rememberLazyListState())
    }
}