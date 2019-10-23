package br.com.washi.delivery.data

import com.google.gson.annotations.SerializedName

data class Delivery(
    @SerializedName("codigo")
    val id: Int,
    @SerializedName("cep")
    val zone: String,
    @SerializedName("logradouro")
    val publicPlace: String,
    @SerializedName("numero")
    val number: String
)
