package com.dinhpx.treeview

import android.util.Log
import java.util.*
import kotlin.streams.asSequence

fun getRandomText(lengthText: Int): String {
    val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    return Random().ints(lengthText.toLong(), 0, source.length)
        .asSequence()
        .map(source::get)
        .joinToString("")
}

fun <T> MutableList<T>.remove(start: Int, end: Int) {
    if(start in this.indices && start in this.indices)  {
        for (i in end downTo start) {
            this.removeAt(i)
        }
    }
}
