package br.com.washi.persistence.preferences

import android.content.SharedPreferences
import br.com.washi.WashiApplication
import br.com.washi.domain.Person
import com.google.gson.Gson

object Preferences {
    private const val PREF_ID = "WASHI"

    private fun preferences(): SharedPreferences {
        val context = WashiApplication.getInstance()
        return context.getSharedPreferences(PREF_ID, 0)
    }

    fun setBoolean(flag: String, value: Boolean) =
        preferences().edit().putBoolean(flag, value).apply()

    fun getBoolean(flag: String) = preferences().getBoolean(flag, false)

    fun saveUser(flag: String, value: Person) {
        val gson = Gson()
        preferences().edit().putString(flag, gson.toJson(value)).apply()
    }

    fun obtainUserLogged(flag: String): Person {
        val gson = Gson()
        val json = preferences().getString(flag, "")
        return gson.fromJson(json, Person::class.java)
    }
}