package com.jimd.randomuserapi.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ResultadoEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val cell: String,
    val email: String,
    val gender: String,
    val location: String,
    val name: String,
    val nat: String,
    val phone: String,
    val picture: String,
)
