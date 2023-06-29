package com.example.mymanhwawithcompose.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymanhwawithcompose.data.Repository
import com.example.mymanhwawithcompose.model.ManhwaModel
import com.example.mymanhwawithcompose.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository
): ViewModel(){
    private val _uiState: MutableStateFlow<UiState<ArrayList<ManhwaModel>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<ArrayList<ManhwaModel>>>
        get() = _uiState

    fun getAllManhwa(){
        viewModelScope.launch {
            repository.getAllManhwa()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect {manhwa ->
                    _uiState.value = UiState.Success(manhwa)
                    Log.d("HASIL: ", manhwa.toString())
                }
        }
    }
}