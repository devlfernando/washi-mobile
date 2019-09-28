package br.com.washi.login.repository

import br.com.washi.login.Result
import br.com.washi.login.datasource.LoginRemoteDataSource
import br.com.washi.login.domain.User
import br.com.washi.login.request.UserRequest
import br.com.washi.login.service.LoginApi


class AuthRepository(private var loginRemoteDataSource: LoginRemoteDataSource) {
    init {
        loginRemoteDataSource = LoginRemoteDataSource(LoginApi.loginService)
    }

    suspend fun hasExistPerson(userRequest: UserRequest): User? {
        return when (val user = loginRemoteDataSource.safeAuthExecute(userRequest)) {
            is Result.Success -> user.data
            is Result.Error -> null
        }
    }

    suspend fun getPersonInfos(id: String): User? {
        return when (val user = loginRemoteDataSource.obtainPerson(id)) {
            is Result.Success -> user.data
            is Result.Error -> null
        }
    }
}