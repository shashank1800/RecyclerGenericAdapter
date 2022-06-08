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
import com.shahankbhat.recyclergenericadapter.util.Callbacks
import com.shahankbhat.recyclergenericadapter.util.DataBinds
import com.shahankbhat.recyclergenericadapter.util.MoreDataBindings

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

        val clickListener = Callbacks<AdapterItemBinding, TestModel>()
        clickListener.add(CallBackModel(R.id.show) { model, position, binding ->
            // R.id.show is the id of a view
            // model : adapter list model
            // position : adapter item position
            // binding : view binding of adapter item


            // We can perform operation on model and binding here and this gets triggered on click of R.id.show view
            Toast.makeText(this@MainActivity, "Show button clicked at $position", Toast.LENGTH_SHORT)
                .show()

            val heading = model.heading
            model.heading = model.subHeading
            model.subHeading = heading

            binding.testModel = model
        })

        val adapter = RecyclerGenericAdapter.Builder<AdapterItemBinding, TestModel>(R.layout.adapter_item, BR.testModel)
            .setClickCallbacks(clickListener)
            .setMoreDataBinds(DataBinds().apply {
                add(MoreDataBindings(BR.subHead, "Subhead"))
                add(MoreDataBindings(BR.viewModel, viewModel))
            }).build()

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.submitList(viewModel.testModelList)
    }

}