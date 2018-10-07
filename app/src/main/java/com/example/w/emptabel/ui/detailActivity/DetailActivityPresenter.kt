package com.example.w.emptabel.ui.detailActivity

import android.support.annotation.NonNull
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import com.example.w.emptabel.Model.Customer
import com.example.w.emptabel.Model.Customers
import com.example.w.emptabel.Service.MyBroadcastReceiver
import io.realm.Realm
import io.realm.RealmResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivityPresenter {

    private var mRealm: Realm =  Realm.getDefaultInstance()//? = null
    private var mainActivity: DetailActivity? = null

    init {
        setPb()
       // mRealm = Realm.getDefaultInstance()
    }

    companion object {
        lateinit var lbm: LocalBroadcastManager
    }

    fun attachView(mainActivity: DetailActivity) {
        this.mainActivity = mainActivity
    }

    fun setPb(){
        val br  = MyBroadcastReceiver()
        mainActivity?.applicationContext?.let { br.installBR(it) }
    }

    fun populateUsers(){
        val randomUserCall: Call<Customers> = mainActivity?.getRandomUserService()!!.getRandomUsers()
        randomUserCall.enqueue(object: Callback<Customers> {

            override fun onResponse(call: Call<Customers>, @NonNull response: Response<Customers>) {
                if (response.isSuccessful())
                {
                    val tmp = response.body()?.results?.get(0)?.customer
                    tmp?.let { insertCustomerIntoRealm(it) }
                }
            }

            override fun onFailure(call: Call<Customers>, t:Throwable) {
                Log.d("ACTIVITY", "NOT OK2")
            }
        })
    }

    private fun insertCustomerIntoRealm(customer: Customer) {
        if(!mRealm.isEmpty){
            mRealm.let {
                it.beginTransaction()

                it.deleteAll()
                val realmCustomer =  it.createObject(Customer::class.java)

                realmCustomer.id        = customer.id
                realmCustomer.name      = customer.name
                realmCustomer.sername   = customer.sername
                realmCustomer.lasname   = customer.lasname
                realmCustomer.tabelId   = customer.tabelId
                realmCustomer.city      = customer.city
                realmCustomer.company   = customer.company
                realmCustomer.positName = customer.positName
                realmCustomer.avatar    = customer.avatar

                it.commitTransaction()
            }
        }

        val tmp: RealmResults<Customer> = mRealm.where(Customer::class.java).findAll()
        mainActivity?.toast(tmp.get(0)?.name.toString())
    }

    fun detachView(){
        mainActivity = null
        mRealm.close()
    }
}

