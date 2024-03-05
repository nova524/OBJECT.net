package com.objective.objectnet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.MainActivities.MainActivity
import com.objective.objectnet.model.LoginResponse
import com.objective.objectnet.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.input_name)
        val passwordEditText = findViewById<EditText>(R.id.input_passwd)
        val loginButton = findViewById<Button>(R.id.btn_submit)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            RetrofitClient.instance.login(username, password).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        System.out.println(loginResponse?.message)
                        System.out.println(loginResponse?.success)
                        if (loginResponse?.success == true) {
                            // 로그인 성공 시 다음 화면으로 이동
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // 로그인 실패 시 사용자에게 알림 표시
                            Toast.makeText(this@LoginActivity, loginResponse?.message, Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        // 서버 응답이 실패한 경우
                        Toast.makeText(this@LoginActivity, "서버 응답이 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // 네트워크 오류 등의 이유로 API 호출 실패 시 처리
                    Toast.makeText(this@LoginActivity, "네트워크 오류: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}