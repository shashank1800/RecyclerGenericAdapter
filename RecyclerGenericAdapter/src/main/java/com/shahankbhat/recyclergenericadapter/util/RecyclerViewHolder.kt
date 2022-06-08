package com.shahankbhat.recyclergenericadapter.util

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by SHASHANK BHAT on 27-Feb-21.
 *
 *
 */

class RecyclerViewHolder<BIND_TYPE : ViewDataBinding>(var binding: BIND_TYPE) :
    RecyclerView.ViewHolder(binding.root) {
    fun <MODEL_TYPE> bindTo(variableId: Int, model: MODEL_TYPE) {
        binding.setVariable(variableId, model)
    }

    fun <MODEL_TYPE> bindClickListener(model: MODEL_TYPE, callbacks: Callbacks<BIND_TYPE, MODEL_TYPE>?){

        callbacks?.forEach { callback ->
            binding.root.findViewById<View>(callback.id).setOnClickListener {
                callback.block(model, bindingAdapterPosition, binding)
            }
        }

    }
}

