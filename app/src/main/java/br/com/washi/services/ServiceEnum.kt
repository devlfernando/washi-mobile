package br.com.washi.services

enum class ServiceEnum(val value: String) {
    WASH("LAVAR"),
    DRY("PASSAR"),
    DELIVERY("ENTREGAR"),
    ORDERS("PEDIDOS"),
    OTHERS("OUTROS")
}