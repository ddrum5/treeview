package com.dinhpx.treeview.base

import androidx.recyclerview.widget.RecyclerView

abstract class BAdapter: RecyclerView.Adapter<BaseViewHolder>() {

    protected val mListData = mutableListOf<Any>()

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(mListData[position], position)
    }

    override fun getItemCount(): Int = mListData.size

    protected fun reset(listData : List<Any>) {
        this.mListData.clear()
        this.mListData.addAll(listData)
        notifyDataSetChanged()
    }

}

