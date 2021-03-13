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
	implementation 'com.github.shashank1800:RecyclerGenericAdapter:1.0.3'
}
 ```
### This is how you can avoid writing an adapter for your recycler view.
To use RecyclerGenericAdapter, instantiate as shown below 

```kotlin

val clickListener = ArrayList<CallBackModel<AdapterItem1Binding, TestModel>>()

clickListener.add(CallBackModel(R.id.show) { model, position, binding ->
    Toast.makeText(this@MainActivity, "Show button clicked", Toast.LENGTH_SHORT)
	.show()
})
val adapter = RecyclerGenericAdapter<AdapterItemBinding, TestModel>(
        R.layout.adapter_item, // layout for adapter
        clickListener,
        BR.testModel           // model variale name which is in xml
)

val testModelList =  ArrayList<TestModel>()
testModelList.add(TestModel(1, "Head 1", "Sub heading 1"))
testModelList.add(TestModel(2, "Head 2", "Sub heading 2"))
adapter.submitList(testModelList)

//Assign the adapter to recycler view

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
    
