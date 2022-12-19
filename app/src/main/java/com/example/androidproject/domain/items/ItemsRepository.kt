package com.example.androidproject.domain.items

import com.example.androidproject.model.ItemsModel

interface ItemsRepository {

    fun getData(): List<ItemsModel>

}