package br.com.washi.login.domain

data class User(
    val code: Int,
    val name: String,
    val email: String,
    val password: String,
    val document: String,
    val telephone: String
)