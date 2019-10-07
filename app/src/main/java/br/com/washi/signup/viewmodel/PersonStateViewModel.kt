package br.com.washi.signup.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.washi.domain.Person
import br.com.washi.persistence.preferences.Preferences
import br.com.washi.signup.data.PersonRequest
import br.com.washi.signup.datasource.SignupRemoteDataSource
import br.com.washi.util.Result
import kotlinx.coroutines.launch

class PersonStateViewModel constructor(private val signupRemoteDataSource: SignupRemoteDataSource) :
    ViewModel() {
    private val _isSignup = MutableLiveData<Boolean>()
    val isSignup: LiveData<Boolean> get() = _isSignup

    fun signupPerson(person: PersonRequest) {
        viewModelScope.launch {
            when (val mPerson = signupRemoteDataSource.signupPerson(person)) {
                is Result.Success -> {
                    saveLocalInfos(mPerson.data)
                    _isSignup.value = true
                }
                is Result.Error -> _isSignup.value = false
            }
        }
    }

    private suspend fun saveLocalInfos(person: Person?) {
        if (person != null)
            Preferences.saveUser("person", person)
    }
}