package com.shoppingapp.securedaily.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.play.integrity.internal.f
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.shoppingapp.securedaily.app.databinding.ActivityReadDataBinding


class ReadData : AppCompatActivity() {

    private lateinit var binding : ActivityReadDataBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadDataBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.readdataBtn.setOnClickListener {

            val noteTitle : String = binding.etusername.text.toString()

            val acct = GoogleSignIn.getLastSignedInAccount(this)
            val personName = acct?.displayName
            if (personName != null) {
                if  (personName.isNotEmpty()){

                    readData(personName)

                }else{

                    Toast.makeText(this,"PLease enter the Username",Toast.LENGTH_SHORT).show()

                }
            }

        }

    }

    private fun readData(noteTitle: String) {

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        val personName = acct?.displayName

        database = FirebaseDatabase.getInstance().getReference("Users")
        if (personName != null) {
            database.child(personName).child(noteTitle).get().addOnSuccessListener {

                if (it.exists()){

                    val noteTitle = it.child("noteTitle").value
                    val noteDes = it.child("noteDes").value
                    val age = it.child("age").value
                    Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()
                    binding.etusername.text.clear()
                    binding.tvnoteTitle.text = noteTitle.toString()
                    binding.tvnoteDes.text = noteDes.toString()
                    binding.tvAge.text = age.toString()

                }else{

                    Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()
                }

            }.addOnFailureListener{

                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


            }
        }



    }
}