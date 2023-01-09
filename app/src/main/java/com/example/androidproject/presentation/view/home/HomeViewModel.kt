package com.example.androidproject.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject.domain.auth.AuthInteractor
import com.example.androidproject.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel

class HomeViewModel @Inject constructor(
    private  val authInteractor: AuthInteractor
):ViewModel() {

    private  val _userCreds = MutableLiveData<UserModel>()

    val userCreds:LiveData<UserModel > =_userCreds


    fun showUserData(){
        viewModelScope.launch(Dispatchers.Main){

            _userCreds.value =authInteractor.getUserCreds()
        }





    }





}