package br.com.washi.login.datasource

import br.com.washi.domain.Person
import br.com.washi.login.ktx.safeApiCall
import br.com.washi.login.request.UserRequest
import br.com.washi.login.service.LoginService
import br.com.washi.util.Result
import java.io.IOException

class LoginRemoteDataSource constructor(private val loginService: LoginService) {

    suspend fun safeAuthExecute(userRequest: UserRequest) = safeApiCall(
        call = { authPerson(userRequest) },
        errorMessage = "Não foi possivel se comunicar com nossos serviços"
    )

    private suspend fun authPerson(userRequest: UserRequest): Result<Person> {
        val person = loginService.makeAuthenticationAsync(userRequest)
        if (person.isSuccessful)
            return Result.Success(person.body())
        return Result.Error(IOException("Erro ao se comunicar com nosso serviço de autenticação"))
    }

    suspend fun obtainPerson(id: String): Result<Person> {
        val person = loginService.obtainPersonInfos(id)
        if (person.isSuccessful)
            return Result.Success(person.body())
        return Result.Error(IOException("Erro ao seu comunicar com nossos serviços"))
    }
}
