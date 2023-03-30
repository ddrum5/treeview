package com.dinhpx.treeview

data class LevelEntity(
    val id: String,
    val title: String,
    val level: Int,
    val children: MutableList<LevelEntity> = mutableListOf()
)