package com.mironenko.internship_task_1.screens.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mironenko.internship_task_1.model.Item

class DiffCallback: DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}