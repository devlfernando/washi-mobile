package br.com.washi.delivery.repository

import br.com.washi.delivery.data.Delivery
import br.com.washi.delivery.service.DeliveryService

class DeliveryRepository(private val deliveryService: DeliveryService) {
    fun obtainDelivery(): List<Delivery> {
        val deliveries = deliveryService.obtainDeliveryList()
        return deliveries.execute().body() ?: listOf()
    }
}