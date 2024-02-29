package com.objective.objectnet.MainActivities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.objective.objectnet.R
import com.objective.objectnet.login.Login

// MainActivity 클래스를 정의합니다. 이 클래스는 AppCompatActivity를 상속받습니다.
class MainActivity : AppCompatActivity() {
    // onCreate 메서드를 오버라이드하여 액티비티가 생성될 때 호출될 코드를 정의합니다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 화면을 activity_main 레이아웃으로 설정합니다.
        setContentView(R.layout.activity_main)

        // Login 클래스의 인스턴스를 생성합니다.
        val login = Login()

        // 예시로 사용할 사용자 이름과 비밀번호를 정의합니다.
        val username = "example_user"
        val password = "example_password"

        // Login 클래스의 loginUser 메서드를 호출하여 사용자를 로그인시킵니다.
        val isLoggedIn = login.loginUser(username, password)

        // 만약 로그인에 성공했다면 다음 코드를 실행합니다.
        if (isLoggedIn) {
            // TODO: 로그인에 성공한 경우 처리할 코드를 여기에 작성합니다.
        } else {
            // TODO: 로그인에 실패한 경우 처리할 코드를 여기에 작성합니다.
        }
    }
}
