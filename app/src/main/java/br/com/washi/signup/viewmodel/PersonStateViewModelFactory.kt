package br.com.washi.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.washi.signup.datasource.SignupRemoteDataSource

@Suppress("UNCHECKED_CAST")
class PersonStateViewModelFactory constructor(private var signupRemoteDataSource: SignupRemoteDataSource) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        PersonStateViewModel(signupRemoteDataSource) as T

}