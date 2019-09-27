package br.com.washi.login.repository

import br.com.washi.login.Result
import br.com.washi.login.datasource.LoginRemoteDataSource
import br.com.washi.login.request.UserRequest
import br.com.washi.login.service.LoginApi


class AuthRepository(private var loginRemoteDataSource: LoginRemoteDataSource) {
    init {
        loginRemoteDataSource = LoginRemoteDataSource(LoginApi.loginService)
    }

    suspend fun hasExistPerson(userRequest: UserRequest): Boolean {
        return when (loginRemoteDataSource.safeAuthExecute(userRequest)) {
            is Result.Success -> true
            is Result.Error -> false
        }
    }
}