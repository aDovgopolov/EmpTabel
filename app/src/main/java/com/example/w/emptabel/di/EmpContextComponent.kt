package com.example.w.emptabel.di

import com.example.w.emptabel.di.DetailActivity.DetailActivityComponent
import com.example.w.emptabel.di.RegisterActivity.RegisterActivityComponent
import dagger.Component

@RandomUserApplicationScope
@Component//(modules = arrayOf(RandomUsersModule::class))
interface EmpContextComponent {

    fun createRegisterActivityComponent(): RegisterActivityComponent
    fun createDetailActivityComponent(): DetailActivityComponent
    //fun injectsMainActivity(mainActivity: DetailActivity)
}