package com.dinhpx.treeview.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class TreeAdapter : RecyclerView.Adapter<TreeViewHolder<ViewBinding, Any>>() {

    protected val mTreeData = mutableListOf<TreeEntity>()
    protected val mListData = mutableListOf<Any>()


    abstract fun getItemView(viewType: Int): Int
    abstract fun getVH(itemView: View, viewType: Int): TreeViewHolder<*, *>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TreeViewHolder<ViewBinding, Any> {
        val itemView =
            LayoutInflater.from(parent.context).inflate(getItemView(viewType), parent, false)
        return getVH(itemView, viewType) as TreeViewHolder<ViewBinding, Any>
    }

    override fun onBindViewHolder(holder: TreeViewHolder<ViewBinding, Any>, position: Int) {
        holder.getExpandView().setOnClickListener {
            handleExpandedView(holder.bindingAdapterPosition)
        }
        holder.onBind(getDataAtPosition(position))
    }

    override fun getItemCount(): Int = mListData.size


    fun resetTreeData(listTreeData: List<TreeEntity>) {
        mTreeData.clear()
        mTreeData.addAll(listTreeData)
        mListData.clear()
        mListData.addAll(listTreeData)
        notifyDataSetChanged()
    }


    private fun handleExpandedView(position: Int) {
        val data = getDataAtPosition(position)
        if (position > -1 && data is TreeEntity) {
            if (data.isExpanded) {
                collapseView(position)
            } else {
                expandedView(position)
            }
        }
    }

    /*  private fun expandedAllView(position: Int) {
          val data = getDataAtPosition(position) as TreeEntity
          if (data.children.isNotEmpty()) {
              val children = flatMapChildren(data.children)
              mListData.addAll(position + 1, children)
              notifyItemRangeInserted((position + 1), children.size)
              data.isExpanded = true
          }
      }*/


    private fun expandedView(position: Int) {
        val data = getDataAtPosition(position) as TreeEntity
        if (data.children.isNotEmpty()) {
            mListData.addAll(position + 1, data.children)
            notifyItemRangeInserted(position + 1, data.children.size)
            data.isExpanded = true
        }
    }


    private fun collapseView(position: Int) {
        val data = getDataAtPosition(position) as TreeEntity
        if (data.children.isNotEmpty()) {
            val children = flatMapExpandedChildren(data.children)
            mListData.removeRange(position + 1, position + children.size)
            notifyItemRangeRemoved((position + 1), children.size)
            data.isExpanded = false
        }
    }

    private fun flatMapChildren(
        listTreeData: List<TreeEntity>,
        listChildren: MutableList<TreeEntity> = mutableListOf()
    ): List<TreeEntity> {
        if (listTreeData.isNotEmpty()) {
            listTreeData.forEach {
                listChildren.add(it)
                it.isExpanded = true
                flatMapExpandedChildren(it.children, listChildren)
            }
        }
        return listChildren
    }


    private fun flatMapExpandedChildren(
        listTreeData: List<TreeEntity>,
        listChildren: MutableList<TreeEntity> = mutableListOf(),
    ): List<TreeEntity> {
        if (listTreeData.isNotEmpty()) {
            listTreeData.forEach {
                listChildren.add(it)
                if (it.isExpanded) {
                    it.isExpanded = false
                    flatMapExpandedChildren(it.children, listChildren)
                }
            }
        }
        return listChildren
    }

    open fun getDataAtPosition(position: Int): Any {
        return mListData[position]
    }

    private fun <T> MutableList<T>.removeRange(start: Int, end: Int) {
        if (start in this.indices && start in this.indices) {
            for (i in end downTo start) {
                this.removeAt(i)
            }
        }
    }
}

