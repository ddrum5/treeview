package com.dinhpx.treeview.base

data class TreeEntity(
    val title: String,
    val level: Int,
    val children: MutableList<TreeEntity> = mutableListOf()
) {
    var isExpanded = false
}