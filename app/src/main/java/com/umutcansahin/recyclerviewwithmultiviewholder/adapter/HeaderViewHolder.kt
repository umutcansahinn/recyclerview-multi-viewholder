package com.umutcansahin.recyclerviewwithmultiviewholder.adapter

import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.recyclerviewwithmultiviewholder.DataItem
import com.umutcansahin.recyclerviewwithmultiviewholder.databinding.TodoHeaderItemBinding

class HeaderViewHolder(private val headerBinding: TodoHeaderItemBinding) :
    RecyclerView.ViewHolder(headerBinding.root) {

    fun bind(header: DataItem.Header) {
        headerBinding.textViewHeader.text = header.header
    }
}