package com.objective.objectnet.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.R

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 로그인 액티비티 초기화 코드 등을 추가할 수 있음
    }

    fun loginUser(username: String, password: String): Boolean {
        // 여기에 로그인 기능을 구현
        // 예를 들어, 사용자 이름과 비밀번호를 확인하여 로그인이 성공하면 true를 반환
        // 만약 로그인이 실패하면 false를 반환

        // 여기에 실제 로그인 처리 코드를 작성
        // 예를 들어, 간단한 예시로 사용자 이름이 "user"이고 비밀번호가 "password"인 경우에만 로그인 성공으로 처리하도록
        val validUsername = "user"
        val validPassword = "password"

        return username == validUsername && password == validPassword
    }

}