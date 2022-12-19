package com.example.androidproject.data.auth

import android.content.SharedPreferences
import com.example.androidproject.data.sharedpref.SharedPreferenceHelper
import com.example.androidproject.domain.auth.AuthRepository
import com.example.androidproject.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private  val sharedPreferenceHelper: SharedPreferenceHelper




):AuthRepository {

    override fun showUserCreds(): UserModel {
        return  sharedPreferenceHelper.getUserCreds()
    }

    override fun doesUserExist(): Boolean {
        return  sharedPreferenceHelper.checkUserExists()

    }

    override fun userLogout() {
        sharedPreferenceHelper.removeUser()
    }

    override fun loginUser(userName: String, userPassword: String) {

        sharedPreferenceHelper.saveUserName(userName)
        sharedPreferenceHelper.saveUserPassword(userPassword)


    }


}