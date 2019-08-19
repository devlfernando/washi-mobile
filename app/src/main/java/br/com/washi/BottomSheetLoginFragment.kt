package br.com.washi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.full_content_login_bottomsheet.*
import org.jetbrains.anko.support.v4.toast

/**

 * Criado por Luis Fernando F. Araujo em 2019-08-15

 **/

class BottomSheetLoginFragment : BottomSheetDialogFragment() {

    override fun getTheme(): Int {
        return R.style.Theme_MaterialComponents_Light_BottomSheetDialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etPasswordInput.requestFocus()

        fab.setOnClickListener { fabButton ->
            toast("Olá, ${etPasswordInput.text}")
        }
    }
}
