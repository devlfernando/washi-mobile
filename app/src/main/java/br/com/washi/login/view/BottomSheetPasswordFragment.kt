package br.com.washi.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import br.com.washi.R
import br.com.washi.login.datasource.LoginRemoteDataSource
import br.com.washi.login.repository.AuthRepository
import br.com.washi.login.request.UserRequest
import br.com.washi.login.service.LoginApi
import br.com.washi.login.viewmodel.LoginViewModel
import br.com.washi.login.viewmodel.LoginViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.full_content_password_bottomsheet.*
import org.jetbrains.anko.support.v4.toast


class BottomSheetPasswordFragment : BottomSheetDialogFragment() {
    private val vm: LoginViewModel by lazy {
        ViewModelProviders.of(
            this,
            LoginViewModelFactory(AuthRepository(LoginRemoteDataSource(LoginApi.loginService)))
        ).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        circularButton.setOnClickListener {
            circularButton.startAnimation()
            vm.isValidUser(UserRequest("ferrugem@mailinator.com", "123@123"))
        }
    }

    override fun onStart() {
        super.onStart()
        startLineningTheViewModel()
    }

    private fun startLineningTheViewModel() {
        vm.isAuthenticated.observe(this) { isAuth ->
            when (isAuth) {
                true -> {
                    nav_login_fragment.findNavController().navigate(
                        BottomSheetPasswordFragmentDirections.actionBottomSheetPasswordToSolicitationNavigationGraph()
                    )
                }
                else -> {
                    toast("Não foi possivel se conectar")
                    circularButton.stopAnimation()
                }
            }
        }
    }
}