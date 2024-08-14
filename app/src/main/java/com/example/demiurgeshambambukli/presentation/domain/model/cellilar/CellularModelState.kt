package com.example.demiurgeshambambukli.presentation.domain.model.cellilar

sealed class CellularModelState {
    data object Alive : CellularModelState()
    data object Dead : CellularModelState()
    data object Life : CellularModelState()
    data object Death : CellularModelState()
}
