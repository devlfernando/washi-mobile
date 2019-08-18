package br.com.washi

import android.os.Bundle
import kotlinx.android.synthetic.main.content_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonStart.setOnClickListener {
            openBottomSheet()
        }
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }

    private fun openBottomSheet() {
        val bottomSheetLoginFragment = BottomSheetLoginFragment()
        bottomSheetLoginFragment.show(supportFragmentManager, bottomSheetLoginFragment.tag)
    }

}
