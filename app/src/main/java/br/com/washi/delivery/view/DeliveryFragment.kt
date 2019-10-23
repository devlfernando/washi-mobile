package br.com.washi.delivery.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.com.washi.BaseFragment

import br.com.washi.R
import br.com.washi.delivery.data.Delivery
import br.com.washi.delivery.repository.DeliveryRepository
import br.com.washi.delivery.service.DeliveryApi
import br.com.washi.util.setUp
import kotlinx.android.synthetic.main.card_delivery_list.view.*
import kotlinx.android.synthetic.main.fragment_delivery.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DeliveryFragment : BaseFragment() {
    private lateinit var deliveryRepository: DeliveryRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        deliveryRepository = DeliveryRepository(DeliveryApi.deliveryService)
        return inflater.inflate(R.layout.fragment_delivery, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayDeliveries()

        toolbar_delivery.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun displayDeliveries() {
        var deliveryList: List<Delivery>
        doAsync {
            deliveryList = deliveryRepository.obtainDelivery()
            uiThread {
                rv_list_delivery.setUp(
                    deliveryList,
                    R.layout.card_delivery_list, { delivery ->
                        tv_initial_delivery.text =
                            (delivery.number.run { this.substring(0, this.length) })
                        tv_delivery_address.text = delivery.publicPlace
                        tv_delivery_zone.append(delivery.zone)
                        tv_delivery_number.append(delivery.number)
                    },
                    {},
                    GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
                )
            }
        }
    }
}
