package com.example.androidproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidproject.MainActivity2.Companion.startMainActivity2


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            startMainActivity2(this, getString(R.string.hello_world_2))
        }
        supportActionBar?.title = " New title for MainActivity"
        val textView = findViewById<TextView>(R.id.textView)


        val btnGoToActivity2 = findViewById<Button>(R.id.btnGoToActivity2)
        btnGoToActivity2.setOnClickListener {
            startActivity(
                Intent(this, MainActivity3::class.java)

                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )

//                MainActivity2 will not be added to the backstack
//                .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)


        }

    }


}





