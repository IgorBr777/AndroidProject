package com.example.androidproject.presentation.view.home

import com.example.androidproject.R
import com.example.androidproject.domain.items.ItemsInteractor
import javax.inject.Inject

class ItemsPresenter @Inject constructor(
    private  val itemsInteractor: ItemsInteractor

) {

private lateinit var  itemsView: ItemsView

fun setView(itemsFragment: ItemsFragment){

    itemsView =itemsFragment
}

   fun getItems(){

       val items =itemsInteractor.getData()

       itemsView.itemsReceive(items)

   }

    fun imageViewClick(){
        itemsView.imageViewClicked(R.id.iv_image)

    }

    fun itemClick(name: String, date: String, imageView: Int){
        itemsView.itemClicked(NavigateWithBundle(name=name, date=date, image=imageView))

    }




}



data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String


)