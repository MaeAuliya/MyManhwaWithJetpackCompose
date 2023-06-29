package com.example.mymanhwawithcompose.di

import com.example.mymanhwawithcompose.data.Repository

object Injection {
    fun provideRepository(): Repository{
        return Repository.getInstance()
    }
}