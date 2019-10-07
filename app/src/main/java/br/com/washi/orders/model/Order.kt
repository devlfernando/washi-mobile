package br.com.washi.orders.model

data class Order(
    val status: String,
    val service: String,
    val quantityItens: Int,
    val totalAmount: String
)