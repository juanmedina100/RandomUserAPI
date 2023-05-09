package com.jimd.randomuserapi.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val city: String,
    //val coordinates: Coordinates,
    val country: String,
    val postcode: Int,
    val state: String,
    //val street: Street,
    //val timezone: Timezone
)
