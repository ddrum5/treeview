package com.dinhpx.treeview.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    protected val listData = mutableListOf<Any>()

    abstract fun getVH(parent: ViewGroup, viewType: Int): BaseViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return getVH(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(listData[position])
    }

    override fun getItemCount(): Int = listData.size



}