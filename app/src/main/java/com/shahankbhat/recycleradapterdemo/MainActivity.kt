package com.shahankbhat.recycleradapterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.shahankbhat.recycleradapterdemo.databinding.ActivityMainBinding
import com.shahankbhat.recycleradapterdemo.databinding.AdapterItem1Binding
import com.shahankbhat.recycleradapterdemo.databinding.AdapterItem2Binding
import com.shahankbhat.recycleradapterdemo.model.Test2Model
import com.shahankbhat.recycleradapterdemo.model.TestModel
import com.shahankbhat.recyclergenericadapter.CallBackModel
import com.shahankbhat.recyclergenericadapter.RecyclerGenericAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val callbacks = ArrayList<CallBackModel<TestModel>>()
        val adapter = RecyclerGenericAdapter<AdapterItem1Binding, TestModel>(
                R.layout.adapter_item_1,
                callbacks,
                BR.testModel
        )

        val testModelList =  ArrayList<TestModel>()
        testModelList.add(TestModel(1, "Head 1", "Sub heading 1"))
        testModelList.add(TestModel(2, "Head 2", "Sub heading 2"))
        adapter.submitList(testModelList)

        val callbacks2 = ArrayList<CallBackModel<Test2Model>>()
        val adapter2 = RecyclerGenericAdapter<AdapterItem2Binding, Test2Model>(
                R.layout.adapter_item_2,
                callbacks2,
                BR.test2Model
        )

        val test2ModelList =  ArrayList<Test2Model>()
        test2ModelList.add(Test2Model(1, "Head 1"))
        test2ModelList.add(Test2Model(2, "Head 2"))
        adapter2.submitList(test2ModelList)

        binding.recyclerView1.adapter = adapter
        binding.recyclerView1.layoutManager = LinearLayoutManager(this)

        binding.recyclerView2.adapter = adapter2
        binding.recyclerView2.layoutManager = LinearLayoutManager(this)
    }
}