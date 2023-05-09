package com.jimd.randomuserapi.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.jimd.randomuserapi.data.local.entities.ResultadoEntity
import com.jimd.randomuserapi.domain.RandomRepository
import com.jimd.randomuserapi.domain.model.ResultadoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserRandomViewModel @Inject constructor(
    private val randomRepository: RandomRepository
): ViewModel() {

    private val _random = MutableLiveData<List<ResultadoModel>>()
    val random = _random

    private val _usuarioID = MutableLiveData<ResultadoEntity>()
    val usuarioID = _usuarioID

    fun getUser(){
        viewModelScope.launch(Dispatchers.IO) {
            randomRepository.getUser().onSuccess {
                //_random.postValue(it)
                Log.i("random","getUsers : $it")
            }.onFailure {
                Log.i("random","RANDOM : $it")
            }
        }
    }


    fun getUserForID(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            randomRepository.getUserForID(id)
            _usuarioID.postValue(randomRepository.getUserForID(id))
        }
    }


    fun getAllUser():LiveData<List<ResultadoEntity>>{
//        val randomA = randomRepository.getAllUser().map {
//            _random.postValue(it)
//        }
        Log.i("random","getAllUser : ")
        return randomRepository.getAllUser()
    }

    fun deleteUser(resultadoEntity: ResultadoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            randomRepository.deleteUser(resultadoEntity)
        }
    }
}