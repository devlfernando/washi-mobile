package br.com.washi.util

import android.view.View
import androidx.recyclerview.widget.RecyclerView

fun <Item> RecyclerView.setUp(
    items: List<Item>,
    layoutResId: Int,
    bindHolder: View.(Item) -> Unit,
    itemClick: Item.() -> Unit = {},
    manager: RecyclerView.LayoutManager
)
        : Kadapter<Item> {
    return Kadapter(items, layoutResId, {
        bindHolder(it)
    }, {
        itemClick()
    }).apply {
        layoutManager = manager
        adapter = this
    }
}