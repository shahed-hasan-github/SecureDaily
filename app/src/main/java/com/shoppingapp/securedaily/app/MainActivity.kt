package com.shoppingapp.securedaily.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.shoppingapp.securedaily.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {

            val noteTitle = binding.noteTitle.text.toString()
            val noteDes = binding.noteDes.text.toString()

            val acct = GoogleSignIn.getLastSignedInAccount(this)
            val userName = acct?.displayName
            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(noteTitle,noteDes)





            if (userName != null) {


                database.child(userName).child(noteTitle).setValue(User).addOnSuccessListener {

                    binding.noteTitle.text.clear()
                    binding.noteDes.text.clear()


                    Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Recyc::class.java)
                    startActivity(intent)
                }.addOnFailureListener{

                    Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


                }
            }


        }

    }
}