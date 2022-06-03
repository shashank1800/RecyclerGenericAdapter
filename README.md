![Maven Central](https://img.shields.io/maven-central/v/io.github.shashank1800/com-shahankbhat-recyclergenericadapter?logoColor=green&style=for-the-badge)

# RecyclerGenericAdapter

Add the dependency
```gradle
dependencies {
	implementation 'io.github.shashank1800:com-shahankbhat-recyclergenericadapter:1.1'
}
 ```

To use RecyclerGenericAdapter, instantiate as shown below

```kotlin

val adapter = RecyclerGenericAdapter.Builder<AdapterItemBinding, TestModel>(
    R.layout.adapter_item,  // layout for adapter
    BR.testModel            // model variable name which is in xml
).build()

recyclerView.adapter = adapter
recyclerView.layoutManager = LinearLayoutManager(this)

adapter.submitList(testModelList)

```

AdapterItemBinding is generated for ```R.layout.adapter_item```, you just have to enable databinding for that.
and since com.exaple.app.BR class is generated while building app, you may not see your model name before first
time running build project.

Recycler adapter item R.layout.adapter_item xml.
```xml

<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <data>
        <variable
            name="testModel"
            type="com.packagename.model.TestModel" />

    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
    ...
  ```

To add click listener for any view

  ```kotlin
val clickListener = ArrayList<CallBackModel<AdapterItemBinding, TestModel>>()
clickListener.add(CallBackModel(R.id.show) { model, position, binding ->
    // R.id.show is the id of a view
    // model : adapter list model
    // position : adapter item position
    // binding : view binding of adapter item
    
    
    // We can perform operation on model and binding here and this gets triggered on click of R.id.show view
    Toast.makeText(this@MainActivity, "Show button clicked at $position", Toast.LENGTH_SHORT).show()

    val heading = model.heading
    model.heading = model.subHeading
    model.subHeading = heading

    binding.testModel = model
})

val adapter = RecyclerGenericAdapter.Builder<AdapterItemBinding, TestModel>(R.layout.adapter_item, BR.testModel)
    .setCallbacks(clickListener)  // set click listeners here
    .build()
  ```

While initializing adapter we declared model as testModel, so it binds list
data to xml testModel. Data variables can used to set the value of views in xml
and also if you want to manipulate data or want to set data after performing
operation bit on model you can make use of static data bindings adapter
methods, that's where you can perform operation on model and set data to views.

If you have any questions or doubts feel free to ask it by raising issue.
Or wants to contribute send PR to this repo.
I'm happy to to hear your suggestions.

⭐ mark this repo, if this was useful or want to use it later. Thanks😊.
    
