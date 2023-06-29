package com.example.mymanhwawithcompose.data

import com.example.mymanhwawithcompose.model.DataSource
import com.example.mymanhwawithcompose.model.ManhwaModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository {

    private val manhwaList = ArrayList<ManhwaModel>()

    init {
        DataSource.manhwaDataSource.forEach{
            manhwaList.add(it)
        }
    }

    fun getAllManhwa() : Flow<ArrayList<ManhwaModel>>{
        return flowOf(manhwaList)
    }

    fun GetDetailManhwa(manhwaId: Int): ManhwaModel{
        return manhwaList.first{
            it.id == manhwaId
        }
    }

    companion object{
        @Volatile
        private var instance: Repository? = null

        fun getInstance(): Repository =
            instance ?: synchronized(this){
                Repository().apply {
                    instance = this
                }
            }
    }

}