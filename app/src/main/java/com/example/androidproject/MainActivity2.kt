package com.example.androidproject

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btnGoToActivity3 = findViewById<Button>(R.id.btnGoToActivity3)
        btnGoToActivity3.setOnClickListener { startActivity(Intent("com.example.androidproject.@+id/btnGoToActivity3")) }
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF018786")))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // supportActionBar?.setBackgroundDrawable(R.drawable.cat)

        val textView2 = findViewById<TextView>(R.id.textView2)

        val data: String = intent.getStringExtra(KEY) ?: getString(R.string.no_data)
        textView2.text = data

//val intentExtras =intent.extras?.get("greeting")
//        Toast.makeText(this,"$intentExtras", Toast.LENGTH_SHORT).show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.close_app -> finishAffinity()
            R.id.goBack -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val KEY = "1"
        fun startMainActivity2(context: Context, string: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY, string)
            context.startActivity(intent)
        }

    }

}



