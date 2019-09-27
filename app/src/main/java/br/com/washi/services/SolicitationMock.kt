package br.com.washi.services

object SolicitationMock {
    val list = arrayListOf<Solicitation>()


    private val serviceType = listOf(
        "Lavagem na máquina",
        "Lavagem à seco"
    )

    private val product = listOf(
        "Amaciante",
        "Sabão em pó"
    )

    private val quantityOfPiece = listOf(
        50,
        10
    )

    private val amount = listOf(
        "R$ 160.00",
        "R$ 90.00"
    )

    fun getSolicitations(): List<Solicitation> {
        for (index in serviceType.indices) {
            list.add(
                Solicitation(
                    serviceType[index * 0],
                    product[index],
                    quantityPiece = quantityOfPiece[index],
                    amount = amount[index]
                )
            )
        }
        return list
    }
}