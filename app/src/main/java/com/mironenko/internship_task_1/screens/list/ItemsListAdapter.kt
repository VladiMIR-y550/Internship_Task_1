package com.mironenko.internship_task_1.screens.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mironenko.internship_task_1.databinding.LayoutItemBinding
import com.mironenko.internship_task_1.model.Item

interface ItemClickListener {
    fun onItemClick(itemId: Int)
}

class ItemsListAdapter(private val clickListener: ItemClickListener) :
    ListAdapter<Item, ItemsListAdapter.ItemViewHolder>(DiffCallback()) {


    private var itemsList: List<Item> = emptyList()

    fun setItemsList(items: List<Item>) {
        itemsList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemsList[position]
        holder.bind(item, clickListener)
    }

    override fun getItemCount() = itemsList.size

    inner class ItemViewHolder(private val binding: LayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item, clickListener: ItemClickListener) {
            binding.tvName.text = item.name
            binding.root.setOnClickListener {
                clickListener.onItemClick(item.id)
            }

        }
    }
}