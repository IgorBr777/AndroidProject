package com.example.androidproject.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel  @Inject constructor(
    private  val authInteractor: AuthInteractor



):ViewModel() {

    private  val _userExist = MutableLiveData<Boolean>()
    val userExist:LiveData<Boolean> = _userExist




    fun checkUserExists(){

_userExist.value =authInteractor.checkUserExists()

    }



}