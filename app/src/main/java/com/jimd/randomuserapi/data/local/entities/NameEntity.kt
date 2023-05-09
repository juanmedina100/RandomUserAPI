package com.jimd.randomuserapi.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NameEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val first: String?,
    val last: String?,
    val title: String?
)
