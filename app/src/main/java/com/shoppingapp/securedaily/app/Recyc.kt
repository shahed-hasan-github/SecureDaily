package com.shoppingapp.securedaily.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Recyc : AppCompatActivity() {
    lateinit var recyclerbtn : Button



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_recyc)

            recyclerbtn = findViewById(R.id.recyclerviewbtn)

            recyclerbtn.setOnClickListener {

                var i = Intent(this, UserlistActivity::class.java)
                startActivity(i)
                finish()


            }
        }
    }
