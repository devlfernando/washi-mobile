package br.com.washi.signup.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import br.com.washi.BaseBottomSheetDialogFragment
import br.com.washi.R
import br.com.washi.signup.data.PersonRequest
import br.com.washi.signup.datasource.SignupRemoteDataSource
import br.com.washi.signup.service.SignupApi
import br.com.washi.signup.viewmodel.PersonStateViewModel
import br.com.washi.signup.viewmodel.PersonStateViewModelFactory
import kotlinx.android.synthetic.main.full_content_person_state_bottomsheet.*
import org.jetbrains.anko.support.v4.toast


class PersonStateBottomSheet : BaseBottomSheetDialogFragment() {
    private val vm: PersonStateViewModel by lazy {
        ViewModelProviders.of(
            this,
            PersonStateViewModelFactory(
                SignupRemoteDataSource(
                    (
                            SignupApi.signupService)
                )
            )
        ).get(PersonStateViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_person_state_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val person = arguments?.get("person") as PersonRequest

        cpb_submit_person.setOnClickListener {
            val lastDataPerson = person.copy(addressState = et_person_state.text.toString())
            cpb_submit_person.startAnimation()
            vm.signupPerson(lastDataPerson)
        }
    }

    override fun onStart() {
        super.onStart()
        startListeningViewModel()
    }

    private fun startListeningViewModel() {
        vm.isSignup.observe(this) { itWorks ->
            when (itWorks) {
                true -> {
                    findNavController()
                        .navigate(
                            PersonStateBottomSheetDirections
                                .actionPersonStateBottomSheetToSolicitationNavigationGraph()
                        )
                }
                false -> {
                    toast("Serviço inacessível, tente novamente mais tarde")
                    cpb_submit_person.revertAnimation()
                }
            }
        }
    }

}
