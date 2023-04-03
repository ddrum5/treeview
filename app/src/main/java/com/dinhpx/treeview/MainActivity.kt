package com.dinhpx.treeview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dinhpx.treeview.base.TreeEntity
import com.dinhpx.treeview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter: LevelAdapter by lazy {
        LevelAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.rvTreeView.adapter = adapter
        adapter.resetTreeData(getTreeData())


    }

    private fun getTreeData(): List<TreeEntity> {
        val listData = mutableListOf<TreeEntity>()
        for (i in 0..2) {
            val level0 = TreeEntity(title = "Level 0", level = 0)
            for (j in 0..1) {
                val level1 =
                    TreeEntity(title = "Level 1", level = 1)
                level0.children.add(level1)
                for (k in 0..1) {
                    val level2 =
                        TreeEntity(title = "Level 2", level = 2)
                    level1.children.add(level2)
                }
            }
            listData.add(level0)
        }
        return listData
    }
}