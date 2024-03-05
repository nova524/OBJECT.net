package com.objective.objectnet.service

import com.objective.objectnet.entity.User
import com.objective.objectnet.model.CheckResponse
import com.objective.objectnet.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("api/check")
    fun checkConnection(): Call<Boolean>

    @POST("api/login")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}