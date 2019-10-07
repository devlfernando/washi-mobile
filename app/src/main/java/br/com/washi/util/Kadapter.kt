package br.com.washi.util

import android.view.View

class Kadapter<Item>(
    items: List<Item>,
    layoutResId: Int,
    private val bindHolder: View.(Item) -> Unit
) : AbstractAdapter<Item>(items, layoutResId) {

    private var itemClick: Item.() -> Unit = {}

    constructor(
        items: List<Item>, layoutResId: Int, bindHolder: View.(Item) -> Unit,
        itemClick: Item.() -> Unit = {}
    ) : this(items, layoutResId, bindHolder) {
        this.itemClick = itemClick
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.bindHolder(itemList[position])
    }

    override fun onItemClick(item: View, position: Int) {
        itemList[position].itemClick()
    }
}