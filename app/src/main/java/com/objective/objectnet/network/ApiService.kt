package com.objective.objectnet.network

import retrofit2.Call
import retrofit2.http.*
import com.objective.objectnet.model.LoginResponse

interface ApiService {
    @POST("login")
    @FormUrlEncoded
    fun login(@Field("username") username: String, @Field("password") password: String): Call<LoginResponse>
}