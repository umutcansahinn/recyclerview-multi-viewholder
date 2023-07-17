package com.umutcansahin.recyclerviewwithmultiviewholder.adapter

import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.recyclerviewwithmultiviewholder.DataItem
import com.umutcansahin.recyclerviewwithmultiviewholder.databinding.TodoItemBinding

class TodoViewHolder(private val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(todo: DataItem.TodoItem) {
        binding.textViewItem.text = todo.todoText
    }
}