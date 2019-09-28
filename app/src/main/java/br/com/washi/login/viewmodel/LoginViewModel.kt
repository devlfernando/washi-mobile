package br.com.washi.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.washi.login.repository.AuthRepository
import br.com.washi.login.request.UserRequest
import br.com.washi.persistence.preferences.Preferences
import kotlinx.coroutines.launch

class LoginViewModel constructor(private var authRepository: AuthRepository) : ViewModel() {
    private val _isAuthenticated = MediatorLiveData<Boolean>()
    val isAuthenticated: LiveData<Boolean> get() = _isAuthenticated

    fun isValidUser(userRequest: UserRequest) {
        viewModelScope.launch {
            val userAuth = authRepository.hasExistPerson(userRequest)
            if (userAuth != null) {
                saveLocalInfos(userAuth.code.toString())
                _isAuthenticated.value = true
            } else {
                _isAuthenticated.value = false
            }
        }
    }

    private fun saveLocalInfos(id: String) {
        viewModelScope.launch {
            val user = authRepository.getPersonInfos(id)
            if (user != null)
                Preferences.savePerson("person", user)
        }
    }
}