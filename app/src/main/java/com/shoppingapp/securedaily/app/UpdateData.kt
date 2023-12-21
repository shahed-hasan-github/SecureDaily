package com.shoppingapp.securedaily.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.shoppingapp.securedaily.app.databinding.ActivityUpdateDataBinding

class UpdateData : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateDataBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateBtn.setOnClickListener {

            val userName = binding.userName.text.toString()
            val noteTitle = binding.noteTitle.text.toString()
            val noteDes = binding.noteDes.text.toString()

            updateData(userName,noteTitle,noteDes)

        }

    }

    private fun updateData(userName: String, noteTitle: String, noteDes: String) {


        database = FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String,String>(
                "noteTitle" to noteTitle,
                "noteDes" to noteDes,
        )

        database.child(userName).updateChildren(user).addOnSuccessListener {

            binding.userName.text.clear()
            binding.noteTitle.text.clear()
            binding.noteDes.text.clear()
            binding.age.text.clear()
            Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()


        }.addOnFailureListener{

            Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()

        }}
}