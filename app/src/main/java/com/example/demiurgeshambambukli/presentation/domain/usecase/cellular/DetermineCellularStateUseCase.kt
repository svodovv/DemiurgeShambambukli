package com.example.demiurgeshambambukli.presentation.domain.usecase.cellular

import com.example.demiurgeshambambukli.presentation.domain.model.cellilar.CellularModelState
import javax.inject.Inject

class DetermineCellularStateUseCase @Inject constructor(

){
    operator fun invoke(): CellularModelState {
        return if ((0..1).random() == 0) {
            CellularModelState.Alive
        } else {
            CellularModelState.Dead
        }
    }
}