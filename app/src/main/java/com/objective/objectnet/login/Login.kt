package com.objective.objectnet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.database.DatabaseHelper

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (loginUser(username, password)) {
                // 로그인 성공 시 다음 화면으로 이동하거나 원하는 작업을 수행
                val intent = Intent(this, com.objective.objectnet.MainActivities.MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // 로그인 실패 시 사용자에게 알림을 표시하거나 원하는 작업을 수행
                // 여기서는 간단한 토스트 메시지를 표시하는 예시를 표시
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loginUser(username: String, password: String): Boolean {
        val validUsername = "user"
        val validPassword = "password"

        return username == validUsername && password == validPassword
    }

    private fun checkLoginCredentials(username: String, password: String): Boolean {
        val dbHelper = DatabaseHelper(this)
        val db = dbHelper.readableDatabase

        val columns = arrayOf("username")
        val selection = "username = ? AND password = ?"
        val selectionArgs = arrayOf(username, password)

        val cursor = db.query("users", columns, selection, selectionArgs, null, null, null)
        val count = cursor.count

        cursor.close()
        db.close()

        return count > 0
    }
}