package com.objective.objectnet.MainActivities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.R
import com.objective.objectnet.login.Login
import android.widget.Button
import android.widget.Toast

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

    }
}
