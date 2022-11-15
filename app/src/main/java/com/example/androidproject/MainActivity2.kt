package com.example.androidproject

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btnGoToActivity3 = findViewById<Button>(R.id.btnGoToActivity3)
        btnGoToActivity3.setOnClickListener { startActivity(Intent("com.example.androidproject.@+id/btnGoToActivity3")) }
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(getString(R.string.purple))))


       // supportActionBar?.setBackgroundDrawable(R.drawable.cat)

        val textView2 = findViewById<TextView>(R.id.textView2)

     //   val  data  = intent.getShortExtra("KEY")?: " no data"
    //    textView2.text = data

val intentExtras =intent.extras?.get("greeting")
        Toast.makeText(this,"$intentExtras", Toast.LENGTH_SHORT).show()

        }

    companion object{
        private  const val GREETING = "GREETING"
        fun startMainActivity2(context: Context, string: String){
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra("greeting","hello world")
            context.startActivity(intent)
        }



    }






  }



