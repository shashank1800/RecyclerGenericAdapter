package com.shahankbhat.recyclergenericadapter

import androidx.databinding.ViewDataBinding

/**
 * Created by SHASHANK BHAT on 28-Feb-21.
 *
 *
 */

public class CallBackModel<BIND_TYPE : ViewDataBinding, MODEL_TYPE>(val id : Int, val block: (model:MODEL_TYPE, position:Int, binding:BIND_TYPE) -> Unit)