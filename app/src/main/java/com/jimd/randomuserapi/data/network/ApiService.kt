package com.jimd.randomuserapi.data.network

import com.jimd.randomuserapi.data.dto.UserDto
import retrofit2.http.GET

interface ApiService {
    @GET("api/")
    suspend fun getUser(): UserDto
}