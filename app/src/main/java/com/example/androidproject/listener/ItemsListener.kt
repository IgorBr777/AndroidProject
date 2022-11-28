package com.example.androidproject.listener

import android.widget.ImageView

interface ItemsListener {


    fun onClick()

    fun onElementSelected(name:String, date:String, imageView: Int)


}