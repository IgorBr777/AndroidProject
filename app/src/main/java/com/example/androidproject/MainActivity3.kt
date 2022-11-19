package com.example.androidproject

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF3700B3")))
//        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(getString(R.string.purple))))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val editText = findViewById<EditText>(R.id.et_text)
        val editText2 = findViewById<EditText>(R.id.et_text2)
        val button3 = findViewById<Button>(R.id.button3)
        val textView = findViewById<TextView>(R.id.tv_text)
        val layout1 = findViewById<TextInputLayout>(R.id.textInputLayout)
        val layout2 = findViewById<TextInputLayout>(R.id.til)

        val rb1 = findViewById<RadioButton>(R.id.rb1)
        val rb2 = findViewById<RadioButton>(R.id.rb2)

        rb1.setOnClickListener {
            if (rb1.isChecked) {

                rb2.isChecked = false
            } else {
                rb1.isChecked = true

            }

        }

        rb2.setOnClickListener {

            if (rb2.isChecked) {

                rb1.isChecked = false
            } else {
                rb2.isChecked = true
            }
        }


        val dialog = AlertDialog.Builder(this)
            .setTitle("Information")
            .setMessage("I am Android Developer")
            .setCancelable(false)
            .setPositiveButton("Ok") { dialog, _ ->
                Toast.makeText(this, "cancelled positive", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
        //   button3.setOnClickListener { textView.text ="${editText.text.toString().isEmpty()} ${editText2.text.toString()}" }

        button3.setOnClickListener {
            dialog.show()
            if (editText.text.toString().isEmpty()) {
                layout1.setErrorIconDrawable(R.drawable.ic_baseline_warning_24)
                editText.error = "email cant be empty"
//                layout1.error = "email cant be empty"
            } else
                if (editText2.text.toString().isEmpty()) {
                layout2.setErrorIconDrawable(R.drawable.ic_baseline_warning_24)
                editText2.error = "password cant be empty"
            }
            else{textView.text ="${editText.text.toString().isEmpty()} ${editText2.text.toString()}"}
                 }

        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    }
