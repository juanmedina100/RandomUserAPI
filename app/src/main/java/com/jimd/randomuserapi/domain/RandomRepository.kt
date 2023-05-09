package com.jimd.randomuserapi.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.jimd.randomuserapi.data.local.dao.ResultadosDao
import com.jimd.randomuserapi.data.local.entities.ResultadoEntity
import com.jimd.randomuserapi.data.network.ApiService
import com.jimd.randomuserapi.domain.model.ResultadoModel
import com.jimd.randomuserapi.until.toEntity
import com.jimd.randomuserapi.until.toModel
import com.jimd.randomuserapi.until.toModel2
import java.lang.Exception
import javax.inject.Inject

class RandomRepository @Inject constructor(
    private val apiService: ApiService,
    private val resultadosDao: ResultadosDao
) {

suspend fun getUser():Result<ResultadoModel>{
    return try {
        val resultado = apiService.getUser()
            val resultadoModel = resultado.results.map {
            it.toModel()
        }
        val resultadoEntity = resultado.results.map {
            it.toEntity()
        }
        inserUser(resultadoEntity.first())
        Result.success(resultadoModel.first())
    }catch (e:Exception){
        Result.failure(e)
    }
    }

    suspend fun getUserForID(id:Int):ResultadoEntity{
        return resultadosDao.getUserForID(id)
    }

    fun getAllUser(): LiveData<List<ResultadoEntity>>{
            try {
            val lista = resultadosDao.getAllUser()
            val lista2=lista.map {
                it.map { it.toModel2() }
            }
            return lista
        }catch (e:Exception) {
            return liveData {  }
        }
    }
    suspend fun inserUser(resultadoEntity: ResultadoEntity){
        resultadosDao.insertUser(resultadoEntity)
    }

    suspend fun deleteUser(resultadoEntity: ResultadoEntity){
        resultadosDao.deleteUser(resultadoEntity)
    }

}