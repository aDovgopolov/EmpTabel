package com.example.w.emptabel

import android.app.Application
import com.example.w.emptabel.Model.Customer
import com.example.w.emptabel.di.DaggerEmpContextComponent
import com.example.w.emptabel.di.EmpContextComponent
import com.example.w.emptabel.ui.DelegatesExt
import io.realm.Realm
import io.realm.RealmConfiguration
import timber.log.Timber

class App: Application(){

    private lateinit var empContextComponent: EmpContextComponent

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }
    
    override fun onCreate() {
        super.onCreate()
        instance = this

        Timber.plant(Timber.DebugTree())
        empContextComponent = DaggerEmpContextComponent.create()
        Realm.init(this)
        initRealm()
    }

    fun initRealm(){
        val realmConfig = RealmConfiguration.Builder()
                .initialData { realm -> realm.createObject(Customer::class.java) }
                .schemaVersion(0) // Must be bumped when the schema changes
                .migration(RealmMigration())
                .build()
        // Realm.deleteRealm(realmConfig); // Delete Realm between app restarts.
        Realm.setDefaultConfiguration(realmConfig)
    }

    fun getInstance():App {
        return instance
    }

    fun provideMainComponent(): EmpContextComponent{
        return empContextComponent
    }

}