package com.shahankbhat.recyclergenericadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.shahankbhat.recyclergenericadapter.util.Callbacks
import com.shahankbhat.recyclergenericadapter.util.DataBinds
import com.shahankbhat.recyclergenericadapter.util.RecyclerViewHolder

/**
 * Created by SHASHANK BHAT on 27-Feb-21.
 *
 *
 */
class RecyclerGenericAdapter<BIND_TYPE : ViewDataBinding, MODEL_TYPE>(
    private val layoutId: Int,
    private val variableId: Int,
    private val callbacks: Callbacks<BIND_TYPE, MODEL_TYPE>? = null,
    private val moreDataBinds: DataBinds? = null
) :
    RecyclerView.Adapter<RecyclerViewHolder<BIND_TYPE>>() {

    private var list: ArrayList<MODEL_TYPE> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewHolder<BIND_TYPE> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<BIND_TYPE>(inflater, layoutId, parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    fun submitList(subList: ArrayList<MODEL_TYPE>) {
        list.addAll(subList)
        notifyDataSetChanged()
    }

    fun replaceList(subList: ArrayList<MODEL_TYPE>) {
        list = subList
        notifyDataSetChanged()
    }

    fun getItemList(): ArrayList<MODEL_TYPE> {
        return list
    }

    fun getItem(position: Int): MODEL_TYPE {
        return list[position]
    }

    fun clearList() {
        list.clear()
        notifyDataSetChanged()
    }

    fun removeItemAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addItemAt(position: Int, model: MODEL_TYPE) {
        list.add(position, model)
        notifyItemInserted(position)
    }

    fun addItem(model: MODEL_TYPE) {
        list.add(model)
        notifyItemInserted(list.size - 1)
    }

    fun replaceItemAt(position: Int, model: MODEL_TYPE){
        list.removeAt(position)
        list.add(position, model)
        notifyItemChanged(position)
    }

    fun notifyItemChangedAt(position: Int){
        notifyItemChanged(position)
    }


    override fun onBindViewHolder(holder: RecyclerViewHolder<BIND_TYPE>, position: Int) {
        val item = list[position]
        holder.bindTo(variableId, item)
        holder.bindClickListener(item, callbacks)

        moreDataBinds?.forEach {
            holder.bindTo(it.modelId, it.model)
        }
    }

    class Builder<BIND_TYPE : ViewDataBinding, MODEL_TYPE>(
        @LayoutRes private val layoutId: Int,
        private val variableId: Int,
    ) {
        var callbacks: Callbacks<BIND_TYPE, MODEL_TYPE>? = null
            private set

        var moreDataBinds: DataBinds? = null
            private set

        fun setClickCallbacks(callbacks: Callbacks<BIND_TYPE, MODEL_TYPE>?) =
            apply { this.callbacks = callbacks }

        fun setMoreDataBinds(moreDataBinds: DataBinds?) =
            apply { this.moreDataBinds = moreDataBinds }

        fun build() = RecyclerGenericAdapter(layoutId, variableId, callbacks, moreDataBinds)
    }
}