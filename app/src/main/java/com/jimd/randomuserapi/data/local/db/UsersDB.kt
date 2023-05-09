package com.jimd.randomuserapi.data.local.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jimd.randomuserapi.data.local.dao.ResultadosDao
import com.jimd.randomuserapi.data.local.entities.LocationEntity
import com.jimd.randomuserapi.data.local.entities.NameEntity
import com.jimd.randomuserapi.data.local.entities.PictureEntity
import com.jimd.randomuserapi.data.local.entities.ResultadoEntity

@Database(entities = [LocationEntity::class,NameEntity::class,PictureEntity::class,ResultadoEntity::class], version = 1, exportSchema = false)
abstract class UsersDB:RoomDatabase() {
    abstract fun resultadoDao():ResultadosDao
}