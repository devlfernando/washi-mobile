package br.com.washi.login.service

import br.com.washi.login.domain.User
import br.com.washi.login.request.UserRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST(value = "/pessoa/auth")
    suspend fun makeAuthenticationAsync(@Body userRequest: UserRequest): Response<User>
}