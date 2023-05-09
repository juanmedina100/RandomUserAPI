package com.jimd.randomuserapi.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jimd.randomuserapi.data.local.db.UsersDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModeule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context)=
        Room.databaseBuilder(context,UsersDB::class.java,"database").build()

    @Singleton
    @Provides
    fun provideDAo(db: UsersDB)=db.resultadoDao()
}