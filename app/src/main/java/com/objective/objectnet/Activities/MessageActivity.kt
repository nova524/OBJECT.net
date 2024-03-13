package com.objective.objectnet.Activities

import android.os.Bundle
import android.os.Message
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging
import com.objective.objectnet.R
import com.objective.objectnet.api.RetrofitClient
import com.objective.objectnet.entity.MessageSender
import com.objective.objectnet.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        val sendMessageButton = findViewById<Button>(R.id.sendButton)

        // FirebaseMessaging 초기화
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                // 토큰 가져오기 실패
                return@addOnCompleteListener
            }

            // 토큰 가져오기 성공
            val token = task.result
        }

        // 메시지 전송 버튼 클릭 시
        sendMessageButton.setOnClickListener {
            val apiService = RetrofitClient.createService(ApiService::class.java)
            val messageSender = MessageSender(apiService)
            var message = Message.obtain()
            message = Message(getUserId, , )
            messageSender.sendMessage(message)
        }
    }
}