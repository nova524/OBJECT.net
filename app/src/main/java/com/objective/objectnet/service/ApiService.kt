package com.objective.objectnet.service

import com.objective.objectnet.entity.User
import com.objective.objectnet.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("api/users")
    fun getAllUsers(): Call<List<User>>

    @POST("login")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}