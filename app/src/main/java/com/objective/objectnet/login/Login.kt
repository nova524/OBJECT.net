package com.objective.objectnet.login

class Login {
    private val validUsername = "example_user"
    private val validPassword = "example_password"

    // 실제로는 이 메서드에서 서버와의 통신을 해야 합니다.
    fun loginUser(username: String, password: String): Boolean {
        // 사용자가 제공한 username과 password가 유효한지 확인합니다.
        return username == validUsername && password == validPassword
    }
}
