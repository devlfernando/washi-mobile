package br.com.washi.services

import br.com.washi.R

object MenuMock {
    fun getSolicitations(): List<Menu> {
        val list = arrayListOf<Menu>()

        val images = intArrayOf(
            R.drawable.ic_bubbles,
            R.drawable.ic_forest,
            R.drawable.ic_helmet,
            R.drawable.ic_hands
        )

        val names = listOf(
            "Lavar",
            "Passar",
            "Entregar",
            "Pedidos"
        )

        for (index in 0 until (names.size)) {
            list.add(Menu(names[index], images[index % images.size]))
        }
        return list
    }
}
