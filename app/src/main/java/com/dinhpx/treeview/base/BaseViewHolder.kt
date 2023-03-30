package com.dinhpx.treeview.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder(protected val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun <T>onBind(data :T)
}