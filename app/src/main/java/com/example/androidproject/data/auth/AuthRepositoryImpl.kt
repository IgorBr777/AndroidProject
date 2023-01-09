package com.example.androidproject.data.auth

import android.content.SharedPreferences
import com.example.androidproject.data.sharedpref.SharedPreferenceHelper
import com.example.androidproject.domain.auth.AuthRepository
import com.example.androidproject.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private  val sharedPreferenceHelper: SharedPreferenceHelper




):AuthRepository {

    override suspend fun showUserCreds(): UserModel {
        return      withContext(Dispatchers.IO){

              sharedPreferenceHelper.getUserCreds()
        }

    }

    override suspend fun doesUserExist(): Boolean {

        return      withContext(Dispatchers.IO){

              sharedPreferenceHelper.checkUserExists()
        }


    }

    override suspend fun userLogout() {
        return      withContext(Dispatchers.IO){

            sharedPreferenceHelper.removeUser()
        }




    }

    override suspend fun loginUser(userName: String, userPassword: String) {
withContext(Dispatchers.IO){

    throw Exception()
    sharedPreferenceHelper.saveUserName(userName)
    sharedPreferenceHelper.saveUserPassword(userPassword)
}
    }


}