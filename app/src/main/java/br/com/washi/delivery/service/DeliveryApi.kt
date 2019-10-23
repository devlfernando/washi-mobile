package br.com.washi.delivery.service

import br.com.washi.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DeliveryApi {
    private fun deliveryApi(retrofit: Retrofit) = retrofit.create(DeliveryService::class.java)

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val deliveryService: DeliveryService = deliveryApi(getRetrofit())
}