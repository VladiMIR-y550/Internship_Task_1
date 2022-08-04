package com.mironenko.internship_task_1.screens.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mironenko.internship_task_1.databinding.LayoutItemBinding
import com.mironenko.internship_task_1.model.Item
import com.mironenko.internship_task_1.screens.list.adapter.DiffCallback

interface ItemClickListener {
    fun onItemClick(itemId: Int)
}

class ItemsListAdapter(private val clickListener: ItemClickListener) :
    ListAdapter<Item, ItemsListAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

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