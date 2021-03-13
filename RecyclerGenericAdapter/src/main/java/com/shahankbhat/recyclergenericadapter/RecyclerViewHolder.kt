package com.shahankbhat.recyclergenericadapter

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by SHASHANK BHAT on 27-Feb-21.
 *
 *
 */

public class RecyclerViewHolder<BIND_TYPE : ViewDataBinding>(var binding: BIND_TYPE) :
    RecyclerView.ViewHolder(binding.root) {
    fun <MODEL_TYPE> bindTo(model: MODEL_TYPE, variableId: Int) {
        binding.notifyPropertyChanged(variableId)
        binding.setVariable(variableId, model)
        binding.executePendingBindings()
    }

    fun <MODEL_TYPE> bindClickListener(model: MODEL_TYPE, callbacks: ArrayList<CallBackModel<BIND_TYPE, MODEL_TYPE>>){

        callbacks.forEach { callback ->
            binding.root.findViewById<View>(callback.id).setOnClickListener {
                callback.block(model, adapterPosition, binding)
            }
        }

    }
}

