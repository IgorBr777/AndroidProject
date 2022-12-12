package com.example.androidproject

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject.model.ItemsModel

class ItemsViewModel(private val myParam: MyParam): ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private  val _msg = MutableLiveData<Int>()
    val msg:LiveData<Int> = _msg

    private  val _bundle =MutableLiveData<NavigateWithBundle?>()
    val bundle:LiveData<NavigateWithBundle?> = _bundle





    fun getData(){

        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.banana, "Banana", "22.07.1999"),
            ItemsModel(R.drawable.android_1, "Android", "10.06.2022"),
            ItemsModel(R.drawable.android_2, "IOS", "15.02.2020"),
            ItemsModel(R.drawable.android_3, "Flutter", "30.11.1986"),
            ItemsModel(R.drawable.android_4, "Python", "18.08.1995"),
            ItemsModel(R.drawable.it_1, "PHP", "10.06.2004"),

            )

        _items.value =listItems

    }

    fun imageViewClick(){


        _msg.value= R.string.imageview_clicked


    }

    fun elementClicked(name: String, date: String, imageView: Int){
        _bundle.value = NavigateWithBundle(image = imageView, name=name, date=date)

    }
fun userNavigated(){

    _bundle.value =null
}



}

data class  NavigateWithBundle(
    val image:Int,
    val name:String,
    val date:String


)
class  MyParam(){


}