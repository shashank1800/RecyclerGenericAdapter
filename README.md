[![](https://jitpack.io/v/shashank1800/RecyclerGenericAdapter.svg)](https://jitpack.io/#shashank1800/RecyclerGenericAdapter)


# RecyclerGenericAdapter

### Step 1. 
Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
### Step 2. 
Add the dependency
```gradle
dependencies {
	implementation 'com.github.shashank1800:RecyclerGenericAdapter:1.1.0'
}
 ```
### This is how you can avoid writing an adapter for your recycler view.
To use RecyclerGenericAdapter, instantiate as shown below 

```kotlin

lateinit var adapter: RecyclerGenericAdapter<AdapterItemBinding, TestModel>
...

val clickListener = ArrayList<CallBackModel<AdapterItemBinding, TestModel>>()
clickListener.add(CallBackModel(R.id.show) { model, position, binding ->
    Toast.makeText(context, "Show button clicked at $position", Toast.LENGTH_SHORT)
        .show()
})

adapter = RecyclerGenericAdapter(
    R.layout.adapter_item, // layout for adapter
    BR.testModel,          // model variable name which is in xml
    clickListener          // adding click listeners is optional
)

binding.recyclerView.adapter = adapter
binding.recyclerView.layoutManager = LinearLayoutManager(this)

adapter.submitList(viewModel.testModelList)

```

Recycler adapter item R.layout.adapter_item

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
    ...
  ```
    ⭐ mark this repo, if this was useful or want to use it later. Thanks😊.
    
