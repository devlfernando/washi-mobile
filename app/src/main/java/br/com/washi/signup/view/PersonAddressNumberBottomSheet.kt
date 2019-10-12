package br.com.washi.signup.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.washi.BaseBottomSheetDialogFragment
import br.com.washi.R
import br.com.washi.signup.data.PersonRequest
import kotlinx.android.synthetic.main.full_content_address_number_bottomsheet.*


class PersonAddressNumberBottomSheet : BaseBottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_person_address_number_bottom_sheet,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab_next_neighborhood.isEnabled = true
        val person = arguments?.get("person") as PersonRequest
        fab_next_neighborhood.setOnClickListener {
            findNavController()
                .navigate(
                    PersonAddressNumberBottomSheetDirections
                        .actionPersonAddressNumberBottomSheetToPersonNeighborhoodBottomSheet(
                            person.copy(addressNumber = et_address_number.text.toString())
                        )
                )
            it.isEnabled = false
        }
    }


}
