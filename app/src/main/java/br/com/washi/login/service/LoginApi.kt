package br.com.washi.login.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginApi {
    private const val BASE_URL = "https://washi-backend.herokuapp.com"

    private fun loginApi(retrofit: Retrofit) = retrofit.create(LoginService::class.java)

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //.client(okHttpClient)


    val loginService: LoginService = loginApi(getRetrofit())
}