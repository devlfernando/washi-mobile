package br.com.washi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.content_login.*


/**
 * Criado por Luis Fernando F. Araujo em 2019-08-19
 */

class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.content_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonStart.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginScreenToBottomSheetLogin())

        }
    }

}
