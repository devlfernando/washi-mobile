package br.com.washi.signup.service

import br.com.washi.domain.Person
import br.com.washi.signup.data.PersonRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupService {
    @POST(value = "/pessoa")
    suspend fun signupPerson(@Body person: PersonRequest): Response<Person>
}