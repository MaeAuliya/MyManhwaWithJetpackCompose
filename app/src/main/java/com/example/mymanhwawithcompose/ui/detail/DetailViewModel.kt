package com.example.mymanhwawithcompose.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymanhwawithcompose.data.Repository
import com.example.mymanhwawithcompose.model.ManhwaModel
import com.example.mymanhwawithcompose.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: Repository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<ManhwaModel>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<ManhwaModel>>
        get() = _uiState

    fun getDetailManhwa(manhwaId: Int){
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.GetDetailManhwa(manhwaId))
        }
    }

}