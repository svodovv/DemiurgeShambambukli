package com.example.demiurgeshambambukli.presentation.domain.usecase.cellular

import com.example.demiurgeshambambukli.presentation.domain.model.cellilar.CellularModel
import com.example.demiurgeshambambukli.presentation.domain.model.cellilar.CellularModelState
import javax.inject.Inject

class AddCellularIfThreeInRowUseCase @Inject constructor(

) {
    operator fun invoke(cellulars: List<CellularModel>): CellularModelState? {
        val size = cellulars.size

        if (size < 3) {
            return null
        }

        val lastThreeCells = cellulars.takeLast(3)

        return if (lastThreeCells.all { it.state == CellularModelState.Alive }){
            CellularModelState.Life
        } else if (lastThreeCells.all { it.state == CellularModelState.Dead }){
            CellularModelState.Death
        } else null

    }
}
