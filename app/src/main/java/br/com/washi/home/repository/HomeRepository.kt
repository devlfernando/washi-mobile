package br.com.washi.home.repository

import br.com.washi.domain.Person
import br.com.washi.persistence.preferences.Preferences

class HomeRepository(private val preferences: Preferences) {
    fun getPersonName(): Person {
        return preferences.obtainUserLogged("person")
    }
}