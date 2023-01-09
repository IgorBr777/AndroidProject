package com.example.androidproject.presentation.view.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private  val authInteractor: AuthInteractor

)      :ViewModel() {

    private  val _nav =MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> =_nav


    fun loginUser(userName:String, userPassword:String){
        val coroutinesExceptionHandler = CoroutineExceptionHandler{_, exception->
            Log.w("exceptionHandler called",exception.toString())


        }

        viewModelScope.launch( CoroutineName("with exception")+Dispatchers.Main +coroutinesExceptionHandler){
try {

    launch {

        authInteractor.loginUser(userName,userPassword)
        _nav.value =Unit
    }

}
    catch (e:Exception)    {

        Log.w("exception","loginUser FAILED")


    }


        }

    }
}
