package br.com.washi.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.washi.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.full_content_login_bottomsheet.*
import org.jetbrains.anko.support.v4.toast

/**

 * Criado por Luis Fernando F. Araujo em 2019-08-15

 **/

class BottomSheetLoginFragment : BottomSheetDialogFragment() {

    override fun getTheme(): Int {
        return R.style.Theme_MaterialComponents_Light_BottomSheetDialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        et_email.requestFocus()

        fab.setOnClickListener {
            toast("Olá, ${et_email.text}")
            nav_login_fragment.findNavController().navigate(
                BottomSheetLoginFragmentDirections.actionBottomSheetToPasswordBottomSheet()
            )
        }
    }
}
