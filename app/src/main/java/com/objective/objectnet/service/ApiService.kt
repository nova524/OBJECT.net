package com.objective.objectnet.service

import com.objective.objectnet.model.CreateAccountRequest
import com.objective.objectnet.model.CreateAccountResponse
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

    @POST("api/createAccount")
    fun createAccount(@Body request: CreateAccountRequest): Call<CreateAccountResponse>
}