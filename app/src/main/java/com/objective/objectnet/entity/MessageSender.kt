package com.objective.objectnet.entity

import android.os.Message
import com.objective.objectnet.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageSender(private val apiService: ApiService) {

    fun sendMessage(message: Message) {
        val call = apiService.sendMessage(message)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    // 메시지 전송 성공
                } else {
                    // 메시지 전송 실패
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // 통신 오류 발생
            }
        })
    }
}