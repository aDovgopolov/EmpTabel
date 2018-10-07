package com.example.w.emptabel.ui

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v4.graphics.drawable.RoundedBitmapDrawable
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.Toast
import com.example.w.emptabel.App
import com.example.w.emptabel.R
import com.example.w.emptabel.R.id.btn_layout
//import com.example.w.emptabel.R.id.btn_toolbar
import com.example.w.emptabel.ctx
import com.example.w.emptabel.ui.passingActivity.PassingActivity
import kotlinx.android.synthetic.main.app_bar.view.*
import org.jetbrains.anko.toast

interface ToolbarManager {

    val toolbar: Toolbar

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar() {
        Log.d("initToolbar", "initToolbar")
        toolbar.inflateMenu(R.menu.menu)
        toolbar.setOnMenuItemClickListener {
        when(it.itemId){
            R.id.action_map -> startPassingActivity()//toast("Karta")
            else -> App.instance.toast("do nothing")
                }
            true
        }

        toolbar.setOnClickListener {
            when(it.id){
                btn_layout -> toast( "tools")
                else -> toast( "nothing")
            }
//            true

//            btn_layout.on {
//
//                Log.d("initToolbar", "initToolbar")
//                toast( "tools")
//
//            }
        }

        val bitmanFactory: Bitmap = BitmapFactory.decodeResource(toolbar.getResources(), R.mipmap.dn_ldap)
        val roundBitmap: RoundedBitmapDrawable = RoundedBitmapDrawableFactory.create(toolbar.getResources(), bitmanFactory)
        roundBitmap.isCircular = true
        roundBitmap.setCornerRadius(Math.max(bitmanFactory.getWidth(), bitmanFactory.getHeight()) / 2.0f);
        toolbar.image_view_photo.setImageDrawable(roundBitmap)


        }

    fun startPassingActivity(){
        val intent = Intent(toolbar.context, PassingActivity::class.java)
        toolbar.ctx.startActivity(intent)
    }

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT){
        Toast.makeText(toolbar.ctx, message,length).show()
    }

}