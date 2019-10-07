package br.com.washi.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.washi.BaseFragment
import br.com.washi.R
import kotlinx.android.synthetic.main.content_login.*


/**
 * Criado por Luis Fernando F. Araujo em 2019-08-19
 */

class LoginFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.content_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_signup.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginScreenToSignupPersonNavigationGraph())
        }

        button_start.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginScreenToBottomSheetLogin())
        }
    }
}
