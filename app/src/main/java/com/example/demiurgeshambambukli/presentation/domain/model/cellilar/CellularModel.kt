package com.example.demiurgeshambambukli.presentation.domain.model.cellilar

import com.example.demiurgeshambambukli.presentation.ui.screens.cellular.CellularImageItem

data class CellularModel(
    val title: String,
    val description: String,
    val imageUrl: String,
    val state: CellularModelState
){
    companion object {
        fun fromState(state: CellularModelState): CellularModel {
            val cellularImageItem = when (state) {
                CellularModelState.Alive -> CellularImageItem.ALIVE
                CellularModelState.Dead -> CellularImageItem.DEAD
                CellularModelState.Life -> CellularImageItem.LIFE
                CellularModelState.Death -> CellularImageItem.DEATH
            }

            return CellularModel(
                title = cellularImageItem.title,
                description = cellularImageItem.description,
                imageUrl = cellularImageItem.imageUrl,
                state = state
            )
        }
    }
}