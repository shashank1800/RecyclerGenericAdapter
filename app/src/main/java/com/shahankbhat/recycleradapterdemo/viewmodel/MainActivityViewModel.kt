package com.shahankbhat.recycleradapterdemo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shahankbhat.recycleradapterdemo.model.TestModel

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    val testModelList = ArrayList<TestModel>()

    init {
        testModelList.add(TestModel(1, "Head 1", "Sub heading 1"))
        testModelList.add(TestModel(2, "Head 2", "Sub heading 2"))
        testModelList.add(TestModel(3, "Head 3", "Sub heading 3"))
        testModelList.add(TestModel(4, "Head 4", "Sub heading 4"))

    }

    var subHead = "Show toast"

}