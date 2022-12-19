package com.example.androidproject.data.sharedpref

import android.content.SharedPreferences
import com.example.androidproject.model.UserModel
import javax.inject.Inject

class SharedPreferenceHelper @Inject constructor(

    private  val shredPreferences:SharedPreferences

) {

    fun saveUserName(name:String?){
        shredPreferences.edit().putString(USER_NAME, name).apply()



    }

    fun saveUserPassword(password:String?){
        shredPreferences.edit().putString(USER_PASSWORD, password).apply()


}

    fun getUserCreds():UserModel{

        val name = shredPreferences.getString(USER_NAME, "")?: " No user"
        val password = shredPreferences.getString(USER_PASSWORD, "")?: " No user"
        return  UserModel(name, password)

    }

    fun  checkUserExists():Boolean{
        val name = shredPreferences.getString(USER_NAME, "")?: " No user"
        val password = shredPreferences.getString(USER_PASSWORD, "")?: " No user"

return (!name.isNullOrEmpty() && !password.isNullOrEmpty())

    }

    fun removeUser(){

        saveUserName(null)
        saveUserPassword(null)


    }

    companion object{

    private  const val  USER_NAME ="USER_NAME"
        private  const val  USER_PASSWORD ="USER_PASSWORD"


    }
}