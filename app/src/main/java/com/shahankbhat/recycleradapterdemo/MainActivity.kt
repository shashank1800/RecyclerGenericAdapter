package com.shahankbhat.recycleradapterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.shahankbhat.recycleradapterdemo.databinding.ActivityMainBinding
import com.shahankbhat.recycleradapterdemo.databinding.AdapterItem1Binding
import com.shahankbhat.recycleradapterdemo.databinding.AdapterItem2Binding
import com.shahankbhat.recycleradapterdemo.model.Test2Model
import com.shahankbhat.recycleradapterdemo.model.TestModel
import com.shahankbhat.recycleradapterdemo.viewmodel.MainActivityViewModel
import com.shahankbhat.recyclergenericadapter.CallBackModel
import com.shahankbhat.recyclergenericadapter.RecyclerGenericAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    lateinit var adapter1: RecyclerGenericAdapter<AdapterItem1Binding, TestModel>
    lateinit var adapter2:RecyclerGenericAdapter<AdapterItem2Binding, Test2Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        initRecyclerView1()
        initRecyclerView2()
    }

    private fun initRecyclerView1() {

        val clickListener = ArrayList<CallBackModel<AdapterItem1Binding, TestModel>>()

        clickListener.add(CallBackModel(R.id.show) { model, position, binding ->
            Toast.makeText(this@MainActivity, "Show button clicked", Toast.LENGTH_SHORT)
                .show()
        })


        adapter1 = RecyclerGenericAdapter(
            R.layout.adapter_item_1,
            clickListener,
            BR.testModel
        )
        binding.recyclerView1.adapter = adapter1
        binding.recyclerView1.layoutManager = LinearLayoutManager(this)

        adapter1.submitList(viewModel.test1ModelList)
    }

    private fun initRecyclerView2() {

        val callbacks2 = ArrayList<CallBackModel<AdapterItem2Binding, Test2Model>>()
        callbacks2.add(CallBackModel(R.id.root) { model, position, binding ->
            Toast.makeText(this@MainActivity, "Position : $position \n$model", Toast.LENGTH_SHORT)
                .show()
        })

        adapter2 = RecyclerGenericAdapter(
            R.layout.adapter_item_2,
            callbacks2,
            BR.test2Model
        )

        binding.recyclerView2.adapter = adapter2
        binding.recyclerView2.layoutManager = LinearLayoutManager(this)

        adapter2.submitList(viewModel.test2ModelList)
    }
}