package com.example.ucp2

import androidx.lifecycle.ViewModel
import com.example.ucp2.data.FormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormViewModel: ViewModel() {
    private val _stateUI = MutableStateFlow(FormUiState())
    val stateUI: StateFlow<FormUiState> = _stateUI.asStateFlow()

    fun setForm(list: MutableList<String>) {
        _stateUI.update { stateSaatini ->
            stateSaatini.copy(
                nama = list[0],
                nim = list[1],
                konsen = list[2],
                judul = list[3],
                dosen1 = list[4],
                dosen2 = list[5]
            )
        }
    }
    fun setD1(d1Pilih: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dosen1 = d1Pilih)
        }
    }
    fun setD2(d2Pilih: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dosen2 = d2Pilih)
        }
    }

}