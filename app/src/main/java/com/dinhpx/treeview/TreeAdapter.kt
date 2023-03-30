package com.dinhpx.treeview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dinhpx.treeview.base.BAdapter
import com.dinhpx.treeview.base.BaseViewHolder
import com.dinhpx.treeview.databinding.Level0Binding
import com.dinhpx.treeview.databinding.Level1Binding
import com.dinhpx.treeview.databinding.Level2Binding

class TreeAdapter : BAdapter() {

    companion object {
        private const val TYPE_LEVEL_0 = 0
        private const val TYPE_LEVEL_1 = 1
        private const val TYPE_LEVEL_2 = 2
    }


    override fun getVH(parent: ViewGroup, viewType: Int): BaseViewHolder {

    }




    inner class Level0VH(binding: Level0Binding) : BaseViewHolder(binding) {



    }



    /*private fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_LEVEL_0 -> {
                Level0VH(Level0Binding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            TYPE_LEVEL_1 -> {
                Level1VH(Level1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            else -> {
                Level2VH(Level2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }*/



}


