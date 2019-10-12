package br.com.washi.signup.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.washi.BaseBottomSheetDialogFragment
import br.com.washi.R
import br.com.washi.signup.data.PersonRequest
import kotlinx.android.synthetic.main.full_content_person_email_bottomsheet.*


class PersonEmailBottomSheet : BaseBottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_email_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab_next_document.isEnabled = true
        val person = arguments?.get("person") as PersonRequest
        fab_next_document.setOnClickListener {
            findNavController()
                .navigate(
                    PersonEmailBottomSheetDirections
                        .actionPersonEmailBottomSheetToPersonDocumentBottomSheet(
                            person
                                .copy(
                                    email = et_person_mail.text.toString()
                                )
                        )
                )
            it.isEnabled = false
        }
    }


}
