package br.com.washi.profile.repository

import br.com.washi.persistence.preferences.Preferences

class ProfileRepository(private val preferences: Preferences) {
    fun getProfileName() = preferences.obtainUserLogged("person").name
}