package com.dinhpx.treeview

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dinhpx.treeview.base.WrapContentLinearLayoutManager
import com.dinhpx.treeview.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter: TreeAdapter by lazy {
        TreeAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.rvTreeView.adapter = adapter
        binding.rvTreeView.layoutManager =
            WrapContentLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter.setTreeData(getTreeData())


    }

    private fun getTreeData(): List<LevelEntity> {
        val listData = mutableListOf<LevelEntity>()
        for (i in 0..2) {
            val level0 = LevelEntity(id = UUID.randomUUID().toString(), title = "Level 0", level = 0)
            for (j in 0..1) {
                val level1 =
                    LevelEntity(id = UUID.randomUUID().toString(), title = "Level 1", level = 1)
                level0.children.add(level1)
                for (k in 0..1) {
                    val level2 =
                        LevelEntity(id = UUID.randomUUID().toString(), title = "Level 2", level = 2)
                    level1.children.add(level2)
                }
            }
            listData.add(level0)
        }
        return listData
    }
}