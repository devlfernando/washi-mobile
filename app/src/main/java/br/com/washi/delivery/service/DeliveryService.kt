package br.com.washi.delivery.service

import br.com.washi.delivery.data.Delivery
import retrofit2.Call
import retrofit2.http.GET

interface DeliveryService {
    @GET(value = "/entrega")
    fun obtainDeliveryList(): Call<List<Delivery>>
}