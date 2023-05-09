package com.jimd.randomuserapi.domain.model

import com.jimd.randomuserapi.data.dto.Location
import com.jimd.randomuserapi.data.dto.Name
import com.jimd.randomuserapi.data.dto.Picture
import com.jimd.randomuserapi.data.local.entities.ResultadoEntity

data class ResultadoModel(
    val cell: String,
    val email: String,
    val gender: String,
    val location: String,
    val name: String,
    val nat: String,
    val phone: String,
    val picture: String,
)
