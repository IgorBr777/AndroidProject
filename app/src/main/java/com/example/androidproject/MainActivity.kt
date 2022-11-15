package com.example.androidproject

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.androidproject.MainActivity2.Companion.startMainActivity2


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
startMainActivity2(this, getString(R.string.hello_world))
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val btn = findViewById<Button>(R.id.btn)
btn.setOnClickListener { startMainActivity2(this,getString(R.string.hello_world_2))
}
        supportActionBar?.title = " New title for MainActivity"
        val textView = findViewById<TextView>(R.id.textView)



        val btnGoToActivity2 = findViewById<Button>(R.id.btnGoToActivity2)
        btnGoToActivity2.setOnClickListener{
            startActivity(Intent(this, MainActivity2::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            //MainActivity2 will not be added to the backstack
//                .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)

            )
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.item_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){

            Toast.makeText(this,"clicked back arrow", Toast.LENGTH_SHORT).show()
//            onBackPressed()
        }
//        if (item.itemId = R.id.close_app){
//            finishAffinity()
//        }

        return super.onOptionsItemSelected(item)
    }


}







