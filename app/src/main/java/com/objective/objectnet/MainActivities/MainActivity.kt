package com.objective.objectnet.MainActivities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.R
import com.objective.objectnet.login.Login
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = "example_user"
        val password = "example_password"

        // 로그인 시도
        attemptLogin(username, password)
    }

    private fun attemptLogin(username: String, password: String) {
        // 로그인 서버와의 통신을 위해 코루틴을 사용함
        GlobalScope.launch(Dispatchers.IO) {
            val login = Login()
            val isLoggedIn = login.loginUser(username, password)

            runOnUiThread {
                if (isLoggedIn) {
                    // TODO: 로그인 성공 시 처리할 코드 작성
                    // 예: 다음 화면으로 이동
                } else {
                    // TODO: 로그인 실패 시 처리할 코드 작성
                    // 예: 사용자에게 오류 메시지 표시
                }
            }
        }
    }
}
