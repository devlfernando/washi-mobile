package br.com.washi.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.washi.profile.repository.ProfileRepository

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory constructor(private var profileRepo: ProfileRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ProfileViewModel(profileRepo) as T

}