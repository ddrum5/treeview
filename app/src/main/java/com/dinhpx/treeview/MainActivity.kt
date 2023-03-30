package com.dinhpx.treeview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dinhpx.treeview.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        getListData()

    }

    private fun getListData(): List<LevelEntity> {
        val listData = mutableListOf<LevelEntity>()
        for (i in 0..4) {
            val level0 = LevelEntity(id = UUID.randomUUID().toString(), title = "vip_0 $i", level = 0)
            for (j in 0..4) {
                val level1 = LevelEntity(id = UUID.randomUUID().toString(), title = "vip_1 $i", level = 1)
                level0.children.add(level1)
                for (k in 0..4) {
                    val level2 = LevelEntity(id = UUID.randomUUID().toString(), title = "vip_2 $i", level = 2)
                    level1.children.add(level2)
                }
            }
            listData.add(level0)
        }
        return listData


    }

}