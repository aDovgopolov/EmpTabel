package com.example.w.emptabel.ui.registerActivity

import android.util.Log
import org.jetbrains.annotations.NotNull
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class RegisterActivityPresenter{

    private var _registerActivity: RegisterActivity? = null

    fun attachView(registerActivity: RegisterActivity){
        _registerActivity = registerActivity
    }

    fun detachView(){
        _registerActivity = null
    }

    fun registerUser(vararg str: String){
        _registerActivity?.pDialog?.setMessage("Registering ...")
        _registerActivity?.showDialog()

        val registerUser: Call<RegistrationResponse> = _registerActivity?.randomUsersApi?.
                registerRandomUsers(str[0], str[1],str[2])!!
        registerUser.enqueue(object: Callback<RegistrationResponse>{

            override fun onResponse(call: Call<RegistrationResponse>, @NotNull response: Response<RegistrationResponse>) {
                if(response.isSuccessful){
                    val tmpFlag = response.body()?.error
                    val tmpMessage = response.body()?.errorMsg
                    Log.d("PRESENTER_TRUE", "${response.body()} + $tmpFlag")
                    _registerActivity.let {
                        it?.message("$tmpMessage")
                      if(!tmpFlag!!) _registerActivity?.openRegisterAcitivty()
                    }
                }
                Log.d("PRESENTER", " ${response}")
                _registerActivity?.hideDialog()
            }

            override fun onFailure(call: Call<RegistrationResponse>?, t: Throwable?) {
                Log.d("PRESENTER", "${t.toString()}")
                Timber.i(t?.message)
            }
        })
        _registerActivity?.hideDialog()
    }

    interface presenterMethods { // rename
        fun message(str: String)
    }
}