package br.com.washi.signup.datasource

import br.com.washi.domain.Person
import br.com.washi.signup.data.PersonRequest
import br.com.washi.signup.service.SignupService
import br.com.washi.util.Result
import java.io.IOException

class SignupRemoteDataSource constructor(private val signupService: SignupService) {

    suspend fun signupPerson(personReq: PersonRequest): Result<Person> {
        val person = signupService.signupPerson(personReq)
        if (person.isSuccessful)
            return Result.Success(person.body())
        return Result.Error(IOException("Erro ao realizar cadastro"))
    }
}