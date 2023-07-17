package com.umutcansahin.recyclerviewwithmultiviewholder.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.recyclerviewwithmultiviewholder.DataItem
import com.umutcansahin.recyclerviewwithmultiviewholder.ViewHolderType
import com.umutcansahin.recyclerviewwithmultiviewholder.databinding.TodoHeaderItemBinding
import com.umutcansahin.recyclerviewwithmultiviewholder.databinding.TodoItemBinding

class TodoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val todoList = arrayListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewHolderType.VIEW_HOLDER_ITEM.ordinal -> {
                TodoViewHolder(
                    TodoItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            ViewHolderType.VIEW_HOLDER_HEADER.ordinal -> {
                HeaderViewHolder(
                    TodoHeaderItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> throw IllegalArgumentException("Invalid ViewType")
        }
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TodoViewHolder -> {
                holder.bind(todoList[position] as DataItem.TodoItem)
            }

            is HeaderViewHolder -> {
                holder.bind(todoList[position] as DataItem.Header)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (todoList[position]) {
            is DataItem.TodoItem -> ViewHolderType.VIEW_HOLDER_ITEM.ordinal
            is DataItem.Header -> ViewHolderType.VIEW_HOLDER_HEADER.ordinal
            else -> throw IllegalArgumentException("Invalid Data")
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(updatedList: List<Any>) {
        todoList.clear()
        todoList.addAll(updatedList)
        notifyDataSetChanged()
    }
}