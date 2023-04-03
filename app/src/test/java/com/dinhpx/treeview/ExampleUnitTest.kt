package com.dinhpx.treeview

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        val list = mutableListOf<Level>()
        for (i in 0..10) {
            list.add(Level(i))
        }
        val listIterator = list.listIterator(7)
        while (listIterator.hasNext()) {
            val item = listIterator.next()
            if (item.name % 2 == 0) {
                listIterator.remove()
            }
        }
        val a = 0

    }
}

class Level(val name: Int)