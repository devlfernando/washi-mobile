package br.com.washi.cart.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.com.washi.BaseFragment

import br.com.washi.R
import br.com.washi.services.SolicitationMock
import br.com.washi.util.setUp
import kotlinx.android.synthetic.main.card_solicitation.view.*
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToMap()
        configureCartList()
        closeCart()
    }

    private fun closeCart() {
        cv_close_card.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun configureCartList() {
        rv_cart_list.setUp(
            SolicitationMock.getSolicitations(),
            R.layout.card_solicitation, {
                tv_initial_value.text = (it.serviceType.substring(0, 2))
                person_name.text = it.serviceType
                type_service.text = it.product
                service_price.text = it.amount
                service_quantity.text = it.quantityPiece.toString().plus(" peças")
            },
            {},
            GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
        )
    }

    private fun goToMap() {
        card_map.setOnClickListener {
            findNavController().navigate(CartFragmentDirections.actionCartFragmentToMapsFragment())
        }
    }
}
