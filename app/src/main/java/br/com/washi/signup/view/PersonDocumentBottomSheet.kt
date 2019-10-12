package br.com.washi.signup.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.washi.BaseBottomSheetDialogFragment
import br.com.washi.R
import br.com.washi.signup.data.PersonRequest
import kotlinx.android.synthetic.main.full_content_person_document_bottomsheet.*


class PersonDocumentBottomSheet : BaseBottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_document_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab_next_person_telephone.isEnabled = true
        val person = arguments?.get("person") as PersonRequest
        fab_next_person_telephone.setOnClickListener {
            findNavController()
                .navigate(
                    PersonDocumentBottomSheetDirections
                        .actionPersonDocumentBottomSheetToPersonTelephoneBottomSheet(
                            person.copy(document = et_person_document.text.toString())
                        )
                )
            it.isEnabled = false
        }
    }


}
