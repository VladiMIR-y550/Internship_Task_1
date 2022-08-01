package com.mironenko.internship_task_1.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mironenko.internship_task_1.model.Item
import com.mironenko.internship_task_1.databinding.LayoutItemBinding

interface ItemClickListener {
    fun onItemClick(itemId: Int)
}

class ItemsListAdapter(private val clickListener: ItemClickListener) :
    RecyclerView.Adapter<ItemsListAdapter.ItemViewHolder>() {

    var itemsList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemsList[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            clickListener.onItemClick(item.id)
        }
    }

    override fun getItemCount() = itemsList.size

    inner class ItemViewHolder(private val binding: LayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.tvName.text = item.name
        }
    }
}