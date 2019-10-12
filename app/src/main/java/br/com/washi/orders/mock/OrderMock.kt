package br.com.washi.orders.mock

import br.com.washi.orders.model.Order

object OrderMock {
    val list = arrayListOf<Order>()

    private val servicesName = listOf(
        "Lavar"
    )

    private val status = listOf(
        "Pendente de retirada",
        "Na lavagem",
        "Entregue"
    )

    private val itensQuantity = listOf(
        10,
        30,
        12
    )

    private val totalAmount = listOf(
        "R$ 250.00",
        "R$ 100.30",
        "R$ 55.00"
    )

    fun getOrders(): List<Order> {
        for (index in 0 until (status.size)) {
            list.add(
                Order(
                    status = status[index],
                    service = servicesName[index * 0],
                    quantityItens = itensQuantity[index],
                    totalAmount = totalAmount[index]
                ) //.plus(" ${servicesName[index * 0 + 1]}")
            )
        }
        return list
    }
}