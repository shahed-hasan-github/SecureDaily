package com.shoppingapp.securedaily.app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class Logout : AppCompatActivity() {
    lateinit var gso: GoogleSignInOptions
    var gsc: GoogleSignInClient? = null
    lateinit var name: TextView
    lateinit var email: TextView
    lateinit var signOutBtn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        signOutBtn = findViewById(R.id.signout)
        gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        gsc = GoogleSignIn.getClient(this, gso!!)
        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            val personName = acct.displayName
            val personEmail = acct.email
            name.setText(personName)
            email.setText(personEmail)
        }
        signOutBtn.setOnClickListener(View.OnClickListener { signOut() })
    }

    fun signOut() {
        gsc!!.signOut().addOnCompleteListener {
            finish()
            startActivity(Intent(this@Logout, LoginActivity::class.java))
        }
    }
}