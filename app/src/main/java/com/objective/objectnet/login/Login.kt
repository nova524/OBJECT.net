package com.objective.objectnet.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.R



class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    private fun loginUser(username: String, password: String): Boolean {
        // 간단한 예시로 사용자 이름이 "user"이고 비밀번호가 "password"인 경우에만 로그인 성공으로 처리
        val validUsername = "user"
        val validPassword = "password"

        return username == validUsername && password == validPassword
    }
}