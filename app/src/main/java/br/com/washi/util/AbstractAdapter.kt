package br.com.washi.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractAdapter<Item> constructor(
    protected var itemList: List<Item>,
    private val layoutResId: Int
) : RecyclerView.Adapter<Holder>() {

    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        val viewHolder = Holder(view)
        val itemView = viewHolder.itemView

        itemView.setOnClickListener {
            val adapterPosition = viewHolder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onItemClick(itemView, adapterPosition)
            }
        }
        return viewHolder
    }

    protected open fun onItemClick(item: View, position: Int) {

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.itemView.bind(item)
    }

    protected open fun View.bind(item: Item) {
    }
}