package com.objective.objectnet.MainActivities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.R
import com.objective.objectnet.login.Login

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Login 클래스의 인스턴스 생성
        val login = Login()
        //에베베베
        // 예시로 로그인 메서드 호출
        val username = "example_user"
        val password = "example_password"
        val isLoggedIn = login.loginUser(username, password)

        if (isLoggedIn) {
            // 로그인에 성공한 경우 처리할 코드
        } else {
            // 로그인에 실패한 경우 처리할 코드
        }
    }
}