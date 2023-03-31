package com.dinhpx.treeview

import java.util.*
import kotlin.streams.asSequence

fun getRandomText(lengthText: Int): String {
    val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    return Random().ints(lengthText.toLong(), 0, source.length)
        .asSequence()
        .map(source::get)
        .joinToString("")
}

fun <T> MutableList<T>.removeRange(start: Int, end: Int) {
    for (i in end downTo start) {
        this.removeAt(i)
    }
}
