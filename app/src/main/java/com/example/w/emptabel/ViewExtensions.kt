package com.example.w.emptabel

import android.content.Context
import android.content.res.Resources
import android.view.View

val View.ctx: Context
    get() = context

 val Context.height: Int
    get() = Resources.getSystem().displayMetrics.heightPixels / 10