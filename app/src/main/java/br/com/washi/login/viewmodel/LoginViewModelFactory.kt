package br.com.washi.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.washi.login.repository.AuthRepository

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory constructor(private var authRepository: AuthRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        LoginViewModel(authRepository) as T

}