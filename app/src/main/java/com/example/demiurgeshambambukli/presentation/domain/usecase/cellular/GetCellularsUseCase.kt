package com.example.demiurgeshambambukli.presentation.domain.usecase.cellular

import com.example.demiurgeshambambukli.presentation.domain.model.cellilar.CellularModel
import com.example.demiurgeshambambukli.presentation.domain.model.cellilar.CellularModelState
import javax.inject.Inject

class GetCellularsUseCase @Inject constructor(

) {
    operator fun invoke(cellularState: CellularModelState): CellularModel{
        val cellularModel = CellularModel.fromState(cellularState)
        return cellularModel
    }
}
