package com.objective.objectnet.CreateAccountActivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.LoginActivity
import com.objective.objectnet.MainActivities.MainActivity
import com.objective.objectnet.R
import com.objective.objectnet.api.RetrofitClient
import com.objective.objectnet.model.CreateAccountRequest
import com.objective.objectnet.model.CreateAccountResponse
import com.objective.objectnet.model.LoginRequest
import com.objective.objectnet.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createaccount)

        val usernameEditText = findViewById<EditText>(R.id.CreateAccount_input_name)
        val passwordEditText = findViewById<EditText>(R.id.CreateAccount_input_passwd)
        val loginButton = findViewById<Button>(R.id.CreateAccount_btn_createaccount)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val createAccountRequest = CreateAccountRequest(username, password)

            RetrofitClient.instance.createAccount(createAccountRequest).enqueue(object : Callback<CreateAccountResponse> {
                override fun onResponse(call: Call<CreateAccountResponse>, response: Response<CreateAccountResponse>) {
                    if (response.isSuccessful) {
                        val CreateAccountResponse = response.body()
                        if (CreateAccountResponse?.success == true) {
                            // 회원가입 성공 시 다음 화면으로 이동
                            val intent = Intent(this@CreateAccountActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // 회원가입 실패 시 사용자에게 알림 표시
                            Toast.makeText(this@CreateAccountActivity, CreateAccountResponse?.message, Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        // 서버 응답이 실패한 경우
                        Toast.makeText(this@CreateAccountActivity, "서버 응답이 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<CreateAccountResponse>, t: Throwable) {
                    // 네트워크 오류 등의 이유로 API 호출 실패 시 처리
                    Toast.makeText(this@CreateAccountActivity, "네트워크 오류: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}