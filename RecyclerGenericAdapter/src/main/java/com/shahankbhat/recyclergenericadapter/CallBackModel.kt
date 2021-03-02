package com.shahankbhat.recyclergenericadapter

/**
 * Created by SHASHANK BHAT on 28-Feb-21.
 *
 *
 */

public class CallBackModel<MODEL_TYPE>(val id : Int, val block: (model:MODEL_TYPE, position:Int) -> Unit)