package com.jimd.randomuserapi.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jimd.randomuserapi.data.local.entities.ResultadoEntity

@Dao
interface ResultadosDao {

    @Query("select * from ResultadoEntity")
    fun getAllUser(): LiveData<List<ResultadoEntity>>

    @Query("select * from resultadoentity where id=:id")
    suspend fun getUserForID(id:Int):ResultadoEntity

    @Insert
    suspend fun insertUser(resultadoEntity: ResultadoEntity)

    @Delete
    suspend fun deleteUser(resultadoEntity: ResultadoEntity)
}