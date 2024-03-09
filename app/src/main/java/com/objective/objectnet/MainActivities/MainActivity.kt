package com.objective.objectnet.MainActivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.CreateAccountActivities.CreateAccountActivity
import com.objective.objectnet.R
import com.objective.objectnet.LoginActivity
import com.objective.objectnet.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.Main_loginButton)
        val createAccountButton = findViewById<Button>(R.id.Main_CreateAccountButton)
        loginButton.setOnClickListener {
            // Retrofit을 사용하여 Spring Boot 애플리케이션의 RESTful API 호출
            RetrofitClient.instance.checkConnection().enqueue(object : Callback<Boolean> {
                override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                    val statusCode = response.code()
                    val mainResponse = response.body()
                    if (response.isSuccessful) {
                        // API 호출 성공 시 로그인 화면으로 이동
                        val intent = Intent(this@MainActivity, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        val message = when (statusCode) {
                            404 -> "API 호출이 실패했습니다: Not Found"
                            500 -> "API 호출이 실패했습니다: Internal Server Error"
                            else -> "API 호출이 실패했습니다: $statusCode"
                        }
                        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Boolean>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "네트워크 오류: ${t.message}", Toast.LENGTH_SHORT).show()
                    System.out.println(t.message)
                }
            })
        }

        createAccountButton.setOnClickListener {
            // Retrofit을 사용하여 Spring Boot 애플리케이션의 RESTful API 호출
            RetrofitClient.instance.checkConnection().enqueue(object : Callback<Boolean> {
                override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                    val statusCode = response.code()
                    if (response.isSuccessful) {
                        // API 호출 성공 시 로그인 화면으로 이동
                        val intent = Intent(this@MainActivity, CreateAccountActivity::class.java)
                        startActivity(intent)
                    } else {
                        val message = when (statusCode) {
                            404 -> "API 호출이 실패했습니다: Not Found"
                            500 -> "API 호출이 실패했습니다: Internal Server Error"
                            else -> "API 호출이 실패했습니다: $statusCode"
                        }
                        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Boolean>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "네트워크 오류: ${t.message}", Toast.LENGTH_SHORT).show()
                    System.out.println(t.message)
                }
            })
        }
    }
}