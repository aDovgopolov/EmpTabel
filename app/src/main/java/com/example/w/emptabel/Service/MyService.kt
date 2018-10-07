package com.example.w.emptabel.Service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MyService: Service() {

    companion object {
        val DOWNLOAD_ACTION = "info.devexchanges.download"
        val PERCENTAGE_STAMP = "percent"
        lateinit var lbm: LocalBroadcastManager
        lateinit var intent: Intent
        lateinit var ex: ExecutorService
    }

    override fun onCreate() {
        super.onCreate()
        lbm = LocalBroadcastManager.getInstance(this)
        ex = Executors.newFixedThreadPool(1)
        val myRun = MyRun()
        ex.execute(myRun)
    }

    inner class MyRun: Runnable{
        override fun run() {
            var tmp: String
            try {
                for(i in 0..30){
                    TimeUnit.MILLISECONDS.sleep(1000)
                    intent = Intent(DOWNLOAD_ACTION)
                    tmp = "" + i
                    intent.putExtra(PERCENTAGE_STAMP, tmp)
                    lbm.sendBroadcast(intent)
                }
            }catch(e: InterruptedException){
                e.printStackTrace();
            }
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}