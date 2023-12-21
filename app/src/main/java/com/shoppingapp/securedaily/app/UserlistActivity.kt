package com.shoppingapp.securedaily.app

import android.annotation.SuppressLint
import android.content.Intent
import android.media.tv.TvContract.Channels.Logo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.database.*

class UserlistActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<User>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlist)


        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<User>()
        getUserData()

    }


    private fun getUserData() {
        val acct = GoogleSignIn.getLastSignedInAccount(this)
        val personName = acct?.displayName

        dbref = personName?.let { FirebaseDatabase.getInstance().getReference("Users").child(it) }!!

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(User::class.java)
                        userArrayList.add(user!!)

                    }

                    userRecyclerview.adapter = MyAdapter(userArrayList)


                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }

    fun noteadd(view: View) {

        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }

    fun nextscan(view: View) {



        val intent = Intent(this,Scan::class.java)
        startActivity(intent)
    }

    fun nextprofile(view: View) {

        val intent = Intent(this,Logout::class.java)
        startActivity(intent)
    }
}