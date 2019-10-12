package br.com.washi.services

object ServiceMock {
    val list = arrayListOf<Service>()

    private val servicesName = listOf(
        "Lavar"
    )

    private val personsName = listOf(
        "Leonardo Luan",
        "Nathan",
        "Manuel Barros",
        "Antônia",
        "Edson Novaes"
    )

    private val itensQuantity = listOf(
        10,
        30,
        12,
        5,
        32
    )

    private val totalAmount = listOf(
        "R$ 200.00",
        "R$ 150.30",
        "R$ 85.21",
        "R$ 50.00",
        "R$ 48.00"
    )

    fun getServices(): List<Service> {
        for (index in 0 until (personsName.size)) {
            list.add(
                Service(
                    personsName[index],
                    servicesName[index * 0],
                    itensQuantity[index],
                    totalAmount[index]
                ) //.plus(" ${servicesName[index * 0 + 1]}")
            )
        }
        return list
    }
}
