package com.objective.objectnet.MainActivities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.R
import com.objective.objectnet.login.Login
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Login 클래스의 인스턴스 생성
        val login = Login()
        //에베베베

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
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