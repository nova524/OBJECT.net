package com.objective.objectnet.MainActivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.R
import com.objective.objectnet.LoginActivity
import com.objective.objectnet.api.RetrofitClient
import com.objective.objectnet.entity.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            // Retrofit을 사용하여 Spring Boot 애플리케이션의 RESTful API 호출
            RetrofitClient.instance.getAllUsers().enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if (response.isSuccessful) {
                        // API 호출 성공 시 로그인 화면으로 이동
                        val intent = Intent(this@MainActivity, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@MainActivity, "API 호출이 실패하였습니다.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "네트워크 오류: ${t.message}", Toast.LENGTH_SHORT).show()                }
            })
        }
    }
}