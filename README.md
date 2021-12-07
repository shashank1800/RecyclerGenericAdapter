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
    ...
  ```
  
  While initializing adapter we declared model as testModel, so it binds list 
data to xml testModel. Data variables can used to set the value of views in xml
and also if you want to manipulate data or want to set data after performing 
operation bit on model you can make make use of static data bindings adapter 
methods, that's where you can perform operation on model and set data to views.

If you have any questions or doubts feel free to ask it by raising issue.
Or wants to contribute send PR to this repo. 
I'm happy to to hear your suggestions.

⭐ mark this repo, if this was useful or want to use it later. Thanks😊.
    
