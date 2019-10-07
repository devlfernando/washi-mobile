package br.com.washi.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.washi.home.repository.HomeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {
    private val _personName = MediatorLiveData<String>()
    val personName: LiveData<String> get() = _personName

    init {
        viewModelScope.launch {
            delay(3800)
            _personName.value = repository.getPersonName().name
        }
    }
}