package com.dinhpx.treeview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dinhpx.treeview.base.BAdapter
import com.dinhpx.treeview.base.BaseViewHolder
import com.dinhpx.treeview.databinding.Level0Binding
import com.dinhpx.treeview.databinding.Level1Binding
import com.dinhpx.treeview.databinding.Level2Binding

class TreeAdapter : BAdapter() {

    private val mListTreeData = mutableListOf<LevelEntity>()


    companion object {
        private const val TYPE_LEVEL_0 = 0
        private const val TYPE_LEVEL_1 = 1
        private const val TYPE_LEVEL_2 = 2
    }


    fun setTreeData(listTreeData: List<LevelEntity>) {
        mListTreeData.clear()
        mListTreeData.addAll(listTreeData)
//        reset(mListTreeData)
        reset(setUpTreeView(mListTreeData))
    }

    private fun setUpTreeView(
        listTreeData: List<LevelEntity>,
        listAny: MutableList<Any> = mutableListOf()
    ): List<Any> {
        if (listTreeData.isNotEmpty()) {
            listTreeData.forEach {
                listAny.add(it)
                setUpTreeView(it.children, listAny)
            }
        }
        return listAny
    }


    private fun expandedNode(position: Int) {
        val data = (mListData[position] as LevelEntity)
        if (data.children.isNotEmpty()) {
            mListData.addAll(position + 1, data.children)
            notifyItemRangeInserted(position + 1, data.children.size)
            data.isExpanded = true
        }
    }

    private fun collapseNode(position: Int) {
        val data = (mListData[position] as LevelEntity)
        if (data.children.isNotEmpty()) {
            mListData.removeRange(position + 1, position + flatMapChildrenSize(data.children))
            notifyItemRangeRemoved(position + 1, flatMapChildrenSize(data.children))
            data.isExpanded = false
        }
    }

    private fun flatMapChildrenSize(listTreeData: List<LevelEntity>): Int {
        /* if (listTreeData.isNotEmpty()) {
             listTreeData.forEach {
                 if (it.isExpanded) {

                 }
             }
         }*/

        return 0
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
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
    }


    override fun getItemViewType(position: Int): Int {
        return (mListData[position] as LevelEntity).level
    }


    inner class Level0VH(private val binding: Level0Binding) : BaseViewHolder(binding) {
        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position > -1) {
                    val data = mListData[position] as LevelEntity
                    if (data.isExpanded) {
                        collapseNode(position)
                    } else {
                        expandedNode(position)
                    }
                }
            }
        }

        override fun onBind(data: Any, position: Int) {
            val levelEntity = data as LevelEntity
            binding.tvTitle.text = levelEntity.title
        }
    }

    inner class Level1VH(private val binding: Level1Binding) : BaseViewHolder(binding) {
        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position > -1) {
                    val data = mListData[position] as LevelEntity
                    if (data.isExpanded) {
                        collapseNode(position)
                    } else {
                        expandedNode(position)
                    }
                }
            }
        }

        override fun onBind(data: Any, position: Int) {
            val levelEntity = data as LevelEntity
            binding.tvTitle.text = levelEntity.title
        }

    }

    inner class Level2VH(private val binding: Level2Binding) : BaseViewHolder(binding) {

        override fun onBind(data: Any, position: Int) {
            val levelEntity = data as LevelEntity
            binding.tvTitle.text = levelEntity.title
        }
    }


}


