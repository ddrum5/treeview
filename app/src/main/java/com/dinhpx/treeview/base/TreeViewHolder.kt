package com.dinhpx.treeview.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType


abstract class TreeViewHolder<VB : ViewBinding, DATA>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    protected var binding: VB
    abstract fun onBind(data: DATA)

    init {
        binding = createBindingInstance(itemView)
    }

    open fun getExpandView() : View {
        return binding.root
    }


    private fun createBindingInstance(itemView: View): VB {
        val vbType = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        val vbClass = vbType as Class<VB>
        val method = vbClass.getMethod("bind", View::class.java)

        // Call VB.inflate(inflater, container, false) Java static method
        return method.invoke(null, itemView) as VB
    }

}
