package com.example.androidproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.androidproject.ListViewKotlinActivity.Companion.listViewKotlinActivityStart
import java.util.Objects

class KotlinActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)


        val btnKotlin = findViewById<Button>(R.id.btnKotlin)

        val person = object {
            val name = "Igor"
            fun develop() {

                Log.w("anonyme class", "called develop fun")
            }
        }
        val person2 = object : Developer {

            val name = "Igor"
            override fun develop() {
                Log.w("anonyme class", "called develop fun")
            }

        }

        val house = HouseBuilder.Builder
            .setStock(3)
            .setSwimpool(false)
            .build()


        btnKotlin.setOnClickListener {
            listViewKotlinActivityStart(this)

            Log.w("housebuilder", "${house.hasSwimpool()} ${house.howManyStocks()}")
            person.develop()
            person2.name
            person2.develop()

//            callAnonymClass(Objects:Developer){
//                override fun develop() {
//                    Log.w("anonym class", "called develop fun Developer ")
//            }



            Toast.makeText(this, person.name, Toast.LENGTH_SHORT).show()

        }

        val lambda = { string: String ->
            Toast.makeText(
                this, "your test is $string",
                Toast.LENGTH_LONG
            ).show()
        }
        lambda("Set text in lambda")

        makeRequest("http://google.com/") { callBackResult ->
            Log.w("callBack result", callBackResult)


        }

        fun returnAnonymClass(string: String)=object {

            fun develop(){
                Log.w("anonym class", "called develop fun from returnType $string")
            }
        }



//    fun  get():String{
//        return ""
//
//    }

//    fun  get2()=""


   fun callAnonymClass(developer: Developer){
            developer.develop()

        }

    }

        fun makeRequest(url:String, argForCallBack:(string:String)->Unit){
        argForCallBack.invoke("callBackResult $url")

    }


    companion object{
        fun kotlinActivityStart(context: Context){

            context.startActivity(Intent(context,KotlinActivity::class.java))

        }

    }


}



interface  Developer{

    fun develop()
}