package br.com.washi.orders.mock

import br.com.washi.orders.model.Order

object OrderMock {
    val list = arrayListOf<Order>()

    private val servicesName = listOf(
        "Lavar",
        "Passar"
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
                    service = servicesName[index * 0].plus(" ${servicesName[index * 0 + 1]}"),
                    status = status[index],
                    quantityItens = itensQuantity[index],
                    totalAmount = totalAmount[index]
                )
            )
        }
        return list
    }
}