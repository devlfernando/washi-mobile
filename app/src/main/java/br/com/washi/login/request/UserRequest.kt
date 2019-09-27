package br.com.washi.login.request

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("senha")
    val password: String
)