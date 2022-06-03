package com.shahankbhat.recycleradapterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.shahankbhat.recycleradapterdemo.databinding.ActivityMainBinding
import com.shahankbhat.recycleradapterdemo.databinding.AdapterItemBinding
import com.shahankbhat.recycleradapterdemo.model.TestModel
import com.shahankbhat.recycleradapterdemo.viewmodel.MainActivityViewModel
import com.shahankbhat.recyclergenericadapter.RecyclerGenericAdapter
import com.shahankbhat.recyclergenericadapter.util.CallBackModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {

        val clickListener = ArrayList<CallBackModel<AdapterItemBinding, TestModel>>()
        clickListener.add(CallBackModel(R.id.show) { model, position, binding ->
            Toast.makeText(this@MainActivity, "Show button clicked at $position", Toast.LENGTH_SHORT)
                .show()

            val heading = model.heading
            model.heading = model.subHeading
            model.subHeading = heading

            binding.testModel = model
        })

        val adapter = RecyclerGenericAdapter.Builder<AdapterItemBinding, TestModel>(R.layout.adapter_item, BR.testModel)
            .setCallbacks(clickListener)
            .build()

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.submitList(viewModel.testModelList)
    }

}