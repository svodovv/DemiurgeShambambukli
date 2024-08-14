package com.example.demiurgeshambambukli.presentation.ui.screens.cellular

import com.example.demiurgeshambambukli.presentation.domain.model.cellilar.CellularModel

data class CellularFillingState (
    val cellularList: List<CellularModel>
){
    companion object{
        val initial = CellularFillingState(
            cellularList = emptyList()
        )
    }
}
