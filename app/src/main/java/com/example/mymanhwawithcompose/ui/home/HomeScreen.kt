package com.example.mymanhwawithcompose.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mymanhwawithcompose.ViewModelFactory
import com.example.mymanhwawithcompose.di.Injection
import com.example.mymanhwawithcompose.model.ManhwaModel
import com.example.mymanhwawithcompose.ui.common.UiState
import com.example.mymanhwawithcompose.ui.component.ManhwaItem


@Composable
fun HomeContent(
    manhwa: ArrayList<ManhwaModel>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit
){
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ){
        items(manhwa){ data ->
            ManhwaItem(image = data.image,
                title = data.title,
                description = stringResource(id = data.description),
                modifier = Modifier.clickable {
                    navigateToDetail(data.id)
                }
            )
        }
    }
}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Int) -> Unit
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState){
            is UiState.Loading -> {
                viewModel.getAllManhwa()
            }
            is UiState.Success -> {
                HomeContent(
                    manhwa = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
            is UiState.Error -> {}
        }
    }
}