package br.com.washi.login.service

import br.com.washi.domain.Person
import br.com.washi.login.request.UserRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LoginService {
    @POST(value = "/pessoa/auth")
    suspend fun makeAuthenticationAsync(@Body userRequest: UserRequest): Response<Person>

    @GET(value = "/pessoa/{id}")
    suspend fun obtainPersonInfos(@Path("id") id: String): Response<Person>
}