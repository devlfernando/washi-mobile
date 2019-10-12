package br.com.washi.services

object SolicitationMock {
    val list = arrayListOf<Solicitation>()


    private val serviceType = listOf(
        "Lavagem na máquina"
    )

    private val product = listOf(
        "Amaciante"
    )

    private val quantityOfPiece = listOf(
        50
    )

    private val amount = listOf(
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