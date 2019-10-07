package br.com.washi.login.service

import br.com.washi.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginApi {
    private fun loginApi(retrofit: Retrofit) = retrofit.create(LoginService::class.java)

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val loginService: LoginService = loginApi(getRetrofit())
}