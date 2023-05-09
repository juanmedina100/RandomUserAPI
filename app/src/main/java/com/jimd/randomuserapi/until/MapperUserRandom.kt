package com.jimd.randomuserapi.until

import com.jimd.randomuserapi.data.dto.Result
import com.jimd.randomuserapi.data.local.entities.ResultadoEntity
import com.jimd.randomuserapi.domain.model.ResultadoModel

fun Result.toModel():ResultadoModel{
    return ResultadoModel(cell = this.cell, email = this.email,
        gender = this.gender,
        location = this.location.toString(),name = this.name.toString(), nat = this.nat,phone=this.phone,picture=this.picture.toString())
}

fun ResultadoEntity.toModel2():ResultadoModel{
    return  ResultadoModel(cell = this.cell, email = this.email, gender = this.gender,
    location = this.location,name=this.name, nat = this.nat,phone=this.phone,picture=this.picture)
}

fun com.jimd.randomuserapi.data.dto.Result.toEntity():ResultadoEntity{
    return ResultadoEntity(
        0, cell = this.cell, email = this.email, gender = this.gender,location = this.location.city,
        name = "${this.name.first} ${this.name.last}", nat = this.nat, phone = this.phone, picture = picture.large
    )
}