package com.example.w.emptabel.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.w.emptabel.App
import com.example.w.emptabel.ctx
import com.example.w.emptabel.R
import org.jetbrains.anko.find
import kotlinx.android.synthetic.main.custom_view.view.*
import java.nio.file.Files.find

class CustomView: RelativeLayout {

    constructor(context: Context) : this(context, null) {init(context)}

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {init(context)}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)  {init(context)}

    private fun init(context: Context) {
        View.inflate(context, R.layout.custom_view, this)
    }

    fun bindView(str1: String, str2: String) {
        txt_1.setText(str1)
        txt_2.setText(str2)
    }
}