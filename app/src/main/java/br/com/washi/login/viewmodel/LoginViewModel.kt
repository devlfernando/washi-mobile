package br.com.washi.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.washi.login.repository.AuthRepository
import br.com.washi.login.request.UserRequest
import kotlinx.coroutines.launch

class LoginViewModel constructor(private var authRepository: AuthRepository) : ViewModel() {
    private val _isAuthenticated = MediatorLiveData<Boolean>()
    val isAuthenticated: LiveData<Boolean> get() = _isAuthenticated

    fun isValidUser(userRequest: UserRequest) {
        viewModelScope.launch {
            when (authRepository.hasExistPerson(userRequest)) {
                true -> _isAuthenticated.value = true
                false -> _isAuthenticated.value = false
            }
        }
    }
}