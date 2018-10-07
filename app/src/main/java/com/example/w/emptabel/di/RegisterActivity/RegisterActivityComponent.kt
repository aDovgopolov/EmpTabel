package com.example.w.emptabel.di.RegisterActivity

import com.example.w.emptabel.ui.registerActivity.RegisterActivity
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(RegisterActivityModule::class))
interface RegisterActivityComponent {

    fun injectRegisterActivity(activity: RegisterActivity)
}