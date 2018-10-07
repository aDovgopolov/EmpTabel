package com.example.w.emptabel.ui.loginActivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.w.emptabel.R
import com.example.w.emptabel.ui.registerActivity.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLinkToRegisterScreen.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
