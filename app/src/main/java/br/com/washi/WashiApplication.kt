package br.com.washi

import android.app.Application

class WashiApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        var appInstance: WashiApplication? = null
        fun getInstance(): WashiApplication {
            checkNotNull(appInstance) { "Configure a classse de Application no Manifest" }
            return appInstance!!
        }
    }
}
