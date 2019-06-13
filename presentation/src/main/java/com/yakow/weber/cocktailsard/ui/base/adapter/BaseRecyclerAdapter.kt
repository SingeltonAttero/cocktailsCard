package com.yakow.weber.cocktailsard.ui.base.adapter

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.yakow.weber.cocktailsard.extension.inflate
import io.reactivex.Observable

/**
 * Created on 13.02.19
 * @author YWeber */
abstract class BaseRecyclerAdapter<T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    abstract val dataSet: MutableList<T>

    abstract fun ActionClicks(): Observable<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = parent.inflate(viewType)
        return createViewHolder(view, viewType)
    }

    override fun onBindViewHolder(viewHolder: VH, position: Int) {
        val obj = getObjectForPosition(position)
        viewHolder.bind(obj)
    }

    override fun getItemViewType(position: Int) = getLayoutIdForPosition(position)

    override fun getItemCount() = dataSet.size

    private fun getObjectForPosition(position: Int): T = dataSet[position]

    abstract fun createViewHolder(view: View, viewType: Int): VH

    @LayoutRes
    abstract fun getLayoutIdForPosition(position: Int): Int

    open fun replaceData(data: List<T>) {
        dataSet.clear()
        dataSet.addAll(data)
        this.notifyDataSetChanged()
    }
}