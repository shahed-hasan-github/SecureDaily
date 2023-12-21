package com.shoppingapp.securedaily.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.shoppingapp.securedaily.app.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {



    private lateinit var binding : ActivityMainBinding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {

            val s = intent.getStringExtra("key").toString()


            val noteTitle = binding.noteTitle.text.toString()
            var noteDes = binding.noteDes.text.toString()

            val acct = GoogleSignIn.getLastSignedInAccount(this)
            val userName = acct?.displayName
            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(noteTitle,noteDes)




            if (userName != null) {



                noteDes

                database.child(userName).child(noteTitle).setValue(User).addOnSuccessListener {

                    binding.noteTitle.text.clear()
                    binding.noteDes.text.clear()


                    Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, UserlistActivity::class.java)
                    startActivity(intent)
                }.addOnFailureListener{

                    Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


                }
            }


        }

    }
}




