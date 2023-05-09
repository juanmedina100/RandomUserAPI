package com.jimd.randomuserapi.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PictureEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val large: String,
    val medium: String,
    val thumbnail: String
)
