package br.com.washi.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.washi.profile.repository.ProfileRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val profileRepository: ProfileRepository) : ViewModel() {
    private val _name = MediatorLiveData<String>()
    val name: LiveData<String> get() = _name

    init {
        viewModelScope.launch {
            obtainProfileName()
        }
    }

    private fun obtainProfileName() {
        _name.value = profileRepository.getProfileName()
    }
}