package com.example.androidproject.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel



class DetailsViewModel @Inject constructor(

    private  val authInteractor: AuthInteractor


):ViewModel() {
    private val _nav = MutableLiveData<Unit?>()
    val nav:LiveData<Unit?> = _nav

    fun logoutUser(){

        viewModelScope.launch(Dispatchers.Main){
            authInteractor.logoutUser()
            _nav.value =Unit
        }


    }

}