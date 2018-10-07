package com.example.w.emptabel.ui.registerActivity

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.w.emptabel.App
import com.example.w.emptabel.R
import com.example.w.emptabel.domain.RandomUsersApi
import com.example.w.emptabel.domain.RegisterUserApi
import com.example.w.emptabel.ui.loginActivity.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*
import javax.inject.Inject

class RegisterActivity : AppCompatActivity(), RegisterActivityPresenter.presenterMethods {

    @Inject
    lateinit var presenter: RegisterActivityPresenter

    @Inject
    lateinit var randomUsersApi: RegisterUserApi

    @Suppress("DEPRECATION")
    lateinit var pDialog:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        pDialog = ProgressDialog(this)
        pDialog.setCancelable(false)

        initComponent()
        btnLinkToLoginScreen.setOnClickListener { openRegisterAcitivty() }

        btnRegister.setOnClickListener {
            if(!name.text.isEmpty() && !email.text.isEmpty() && !password.text.isEmpty()){
                presenter.registerUser(name.text.toString(), email.text.toString(), password.text.toString())
            }else{
                when {
                    name.text.isEmpty() -> {
                        name.hint = "Enter you name"
                        name.setHintTextColor(Color.RED)
                    }
                    email.text.isEmpty() -> {
                        email.hint = "Enter you email"
                        email.setHintTextColor(Color.RED)
                    }
                    else -> {
                        password.hint = "Enter you password"
                        password.setHintTextColor(Color.RED) }
                }
            }
        }
    }

    private fun initComponent() {
        val registerActivityComponent = App.instance.provideMainComponent().createRegisterActivityComponent()
        registerActivityComponent.injectRegisterActivity(this)
        presenter.attachView(this)
    }

    fun showDialog() {
        if (!pDialog.isShowing()){
            pDialog.show()
        }
    }

    fun hideDialog() {
        if (pDialog.isShowing()){
            pDialog.dismiss()
        }
    }

    fun openRegisterAcitivty(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun message(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
