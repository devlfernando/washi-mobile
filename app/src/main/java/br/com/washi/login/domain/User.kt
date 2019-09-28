package br.com.washi.login.domain

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("codigo")
    val code: Int,
    @SerializedName("nome")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("senha")
    val password: String,
    @SerializedName("documento")
    val document: String,
    @SerializedName("telefone")
    val telephone: String
)