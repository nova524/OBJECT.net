package com.objective.objectnet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.api.RetrofitClient
import com.objective.objectnet.entity.User
import com.objective.objectnet.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.input_name)
        val passwordEditText = findViewById<EditText>(R.id.input_passwd)
        val loginButton = findViewById<Button>(R.id.btn_submit)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Retrofit을 사용하여 서버로 로그인 요청을 전송
            RetrofitClient.instance.login(username, password).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        // 로그인 성공 시 다음 화면으로 이동하거나 원하는 작업을 수행
                        val intent = Intent(this@Login, com.objective.objectnet.MainActivities.MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // 로그인 실패 시 사용자에게 알림을 표시하거나 원하는 작업을 수행
                        // 여기서는 간단한 토스트 메시지를 표시하는 예시를 표시
                        Toast.makeText(this@Login, "로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // 네트워크 오류 등의 이유로 API 호출 실패 시 처리
                    Toast.makeText(this@Login, "네트워크 오류: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}