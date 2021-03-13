package com.shahankbhat.recycleradapterdemo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shahankbhat.recycleradapterdemo.model.Test2Model
import com.shahankbhat.recycleradapterdemo.model.TestModel

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    val test1ModelList = ArrayList<TestModel>()
    val test2ModelList = ArrayList<Test2Model>()

    init {
        test1ModelList.add(TestModel(1, "Head 1", "Sub heading 1"))
        test1ModelList.add(TestModel(2, "Head 2", "Sub heading 2"))
        test1ModelList.add(TestModel(3, "Head 3", "Sub heading 3"))
        test1ModelList.add(TestModel(4, "Head 4", "Sub heading 4"))

        test2ModelList.add(Test2Model(1, "Head 1"))
        test2ModelList.add(Test2Model(2, "Head 2"))
        test2ModelList.add(Test2Model(3, "Head 1"))
        test2ModelList.add(Test2Model(4, "Head 2"))
    }

}