package com.objective.objectnet.database

import retrofit2.Call
import retrofit2.http.*
import com.objective.objectnet.model.LoginResponse

interface DatabaseService {
    // 예시: 사용자 로그인 요청
    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}