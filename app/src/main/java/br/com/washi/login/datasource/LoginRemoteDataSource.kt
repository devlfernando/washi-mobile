package br.com.washi.login.datasource

import br.com.washi.login.Result
import br.com.washi.login.domain.User
import br.com.washi.login.ktx.safeApiCall
import br.com.washi.login.request.UserRequest
import br.com.washi.login.service.LoginService
import java.io.IOException

class LoginRemoteDataSource constructor(private val loginService: LoginService) {

    suspend fun safeAuthExecute(userRequest: UserRequest) = safeApiCall(
        call = { authPerson(userRequest) },
        errorMessage = "Não foi possivel se comunicar com nossos serviços"
    )

    private suspend fun authPerson(userRequest: UserRequest): Result<User> {
        val person = loginService.makeAuthenticationAsync(userRequest)
        if (person.isSuccessful)
            return Result.Success(person.body())
        return Result.Error(IOException("Erro ao se comunicar com nosso serviço de autenticação"))
    }
}
