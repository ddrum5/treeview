package com.dinhpx.treeview

import android.view.View
import com.dinhpx.treeview.base.TreeAdapter
import com.dinhpx.treeview.base.TreeEntity
import com.dinhpx.treeview.base.TreeViewHolder
import com.dinhpx.treeview.databinding.Level0Binding
import com.dinhpx.treeview.databinding.Level1Binding
import com.dinhpx.treeview.databinding.Level2Binding

class LevelAdapter : TreeAdapter() {

    companion object {
        private const val TYPE_LEVEL_0 = 0
        private const val TYPE_LEVEL_1 = 1
    }


    override fun getItemView(viewType: Int): Int {
        return when (viewType) {
            TYPE_LEVEL_0 -> {
                R.layout.level0
            }
            TYPE_LEVEL_1 -> {
                R.layout.level1
            }
            else -> {
                R.layout.level2
            }
        }
    }

    override fun getVH(itemView: View, viewType: Int): TreeViewHolder<*, *> {
        return when (viewType) {
            TYPE_LEVEL_0 -> {
                Level0VH(itemView)
            }
            TYPE_LEVEL_1 -> {
                Level1VH(itemView)
            }
            else -> {
                Level2VH(itemView)

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return (getDataAtPosition(position) as TreeEntity).level
    }


    class Level0VH(itemView: View) : TreeViewHolder<Level0Binding, TreeEntity>(itemView) {
        override fun onBind(data: TreeEntity) {
            binding.tvTitle.text = data.title
        }

    }

    class Level1VH(itemView: View) : TreeViewHolder<Level1Binding, TreeEntity>(itemView) {
        override fun onBind(data: TreeEntity) {
            binding.tvTitle.text = data.title
        }

    }

    class Level2VH(itemView: View) : TreeViewHolder<Level2Binding, TreeEntity>(itemView) {
        override fun onBind(data: TreeEntity) {
            binding.tvTitle.text = data.title
        }
    }


}


