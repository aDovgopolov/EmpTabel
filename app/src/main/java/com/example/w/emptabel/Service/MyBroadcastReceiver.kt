package com.example.w.emptabel.Service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v4.content.LocalBroadcastManager
import android.util.Log

class MyBroadcastReceiver: BroadcastReceiver(){

    lateinit var context: Context

    override fun onReceive(p0: Context?, p1: Intent?) {
        //Log.d("TAG", p1?.getStringExtra(MyService.PERCENTAGE_STAMP))
    }

    fun installBR(ctx: Context){
        this.context = ctx
        registerReceiver()
        context.startService(Intent(context, MyService::class.java))
    }

    fun registerReceiver(){
        LocalBroadcastManager.getInstance(context)
                .registerReceiver(this, IntentFilter(MyService.DOWNLOAD_ACTION))
    }
}