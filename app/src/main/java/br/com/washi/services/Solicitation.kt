package br.com.washi.services

data class Solicitation(
    val serviceType: String, val product: String, val quantityPiece: Int,
    val amount: String
)