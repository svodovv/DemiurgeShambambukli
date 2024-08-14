package com.example.demiurgeshambambukli.presentation.ui.screens.cellular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demiurgeshambambukli.presentation.domain.usecase.cellular.AddCellularIfThreeInRowUseCase
import com.example.demiurgeshambambukli.presentation.domain.usecase.cellular.DetermineCellularStateUseCase
import com.example.demiurgeshambambukli.presentation.domain.usecase.cellular.GetCellularsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CellularFillingViewModel @Inject constructor(
    private val determineCellularStateUseCase: DetermineCellularStateUseCase,
    private val getCellularsUseCase: GetCellularsUseCase,
    private val addCellularIfThreeInRowUseCase: AddCellularIfThreeInRowUseCase
): ViewModel() {

    private val _state = MutableStateFlow(CellularFillingState.initial)
    val state = _state.asStateFlow()

    fun sendIntent(intent: CellularFillingIntent) {
        when(intent){
            CellularFillingIntent.GenerateCellular -> generateCellulars()
        }
    }

    private fun generateCellulars() {
        viewModelScope.launch {
            val determine = determineCellularStateUseCase()
            val cellular = getCellularsUseCase(determine)
            val cellularList = state.value.cellularList + cellular

            _state.update { it.copy(cellularList = cellularList) }

            addCellularIfThreeInRow()
        }
    }

    private fun  addCellularIfThreeInRow(){
        viewModelScope.launch {
            val cellularState = addCellularIfThreeInRowUseCase(state.value.cellularList)

            if (cellularState != null){
                val cellular = getCellularsUseCase(cellularState)
                val cellularList = state.value.cellularList + cellular

                _state.update { it.copy(cellularList = cellularList) }
            }

        }
    }
}
