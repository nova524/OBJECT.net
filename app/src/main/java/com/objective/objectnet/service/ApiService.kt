package com.objective.objectnet.service

import android.os.Message
import com.objective.objectnet.model.CreateAccountRequest
import com.objective.objectnet.model.CreateAccountResponse
import com.objective.objectnet.model.LoginRequest
import com.objective.objectnet.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("api/check")
    fun checkConnection(): Call<Boolean>

    @POST("api/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("api/register")
    fun createAccount(@Body request: CreateAccountRequest): Call<CreateAccountResponse>

    @POST("api/message")
    fun sendMessage(@Body message: Message): Call<Void>
}