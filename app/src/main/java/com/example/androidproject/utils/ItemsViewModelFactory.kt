package com.example.androidproject.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidproject.domain.items.ItemsInteractor
import com.example.androidproject.presentation.view.home.ItemsViewModel

class ItemsViewModelFactory (private val interactor: ItemsInteractor):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(interactor) as T
    }

}