package br.com.washi.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.washi.home.repository.HomeRepository

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory constructor(private var homeRepository: HomeRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        HomeViewModel(homeRepository) as T

}