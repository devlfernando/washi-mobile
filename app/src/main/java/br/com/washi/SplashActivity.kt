package br.com.washi

import android.content.Intent
import android.os.Bundle

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
