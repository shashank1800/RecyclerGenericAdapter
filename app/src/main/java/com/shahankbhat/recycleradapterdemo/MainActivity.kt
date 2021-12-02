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
import com.shahankbhat.recyclergenericadapter.CallBackModel
import com.shahankbhat.recyclergenericadapter.RecyclerGenericAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    lateinit var adapter: RecyclerGenericAdapter<AdapterItemBinding, TestModel>

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
        })

        adapter = RecyclerGenericAdapter(
            R.layout.adapter_item,
            BR.testModel,
            clickListener
        )

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.submitList(viewModel.testModelList)
    }

}