package com.example.androidproject.data

import com.example.androidproject.R
import com.example.androidproject.domain.ItemsRepository
import com.example.androidproject.model.ItemsModel
import javax.inject.Inject


class ItemsRepositoryImpl @Inject constructor() :ItemsRepository {


    override fun getData(): List<ItemsModel> {

        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.banana, "Banana", "22.07.1999"),
            ItemsModel(R.drawable.android_1, "Android", "10.06.2022"),
            ItemsModel(R.drawable.android_2, "IOS", "15.02.2020"),
            ItemsModel(R.drawable.android_3, "Flutter", "30.11.1986"),
            ItemsModel(R.drawable.android_4, "Python", "18.08.1995"),
            ItemsModel(R.drawable.it_1, "PHP", "10.06.2004"),

            )
        return listItems
    }
}