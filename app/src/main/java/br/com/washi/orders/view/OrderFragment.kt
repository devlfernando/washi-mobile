package br.com.washi.orders.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.com.washi.R
import br.com.washi.orders.mock.OrderMock
import br.com.washi.util.setUp
import kotlinx.android.synthetic.main.card_orders_list.view.*
import kotlinx.android.synthetic.main.fragment_order.*

class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureOrdersByUser()
        closeOrders()
    }

    private fun closeOrders() {
        toolbar_orders.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun configureOrdersByUser() {
        rv_list_orders.setUp(
            OrderMock.getOrders(),
            R.layout.card_orders_list, {
                inicial_order.text = (it.service.substring(0, 2))
                tv_status_order.text = it.status
                type_order.text = it.service
                order_price.text = it.totalAmount
                order_quantity.text = it.quantityItens.toString().plus(" peças")
            },
            {},
            manager = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
        )
    }
}