package br.com.washi.splash.view

import android.content.Intent
import android.os.Bundle
import br.com.washi.BaseActivity
import br.com.washi.login.view.LoginActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }


}
