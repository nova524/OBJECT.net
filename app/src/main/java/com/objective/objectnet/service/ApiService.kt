package com.objective.objectnet.service

import com.objective.objectnet.entity.User
import com.objective.objectnet.model.CheckResponse
import com.objective.objectnet.model.LoginRequest
import com.objective.objectnet.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("api/check") // http://125.248.179.97:8080/api/check
    fun checkConnection(): Call<Boolean>

    @POST("api/IDK")
    fun IDKConnection(): Call<Boolean>

    @POST("api/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}