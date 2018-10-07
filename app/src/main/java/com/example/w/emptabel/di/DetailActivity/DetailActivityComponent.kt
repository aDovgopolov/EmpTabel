package com.example.w.emptabel.di.DetailActivity

import com.example.w.emptabel.domain.RandomUsersApi
import com.example.w.emptabel.ui.detailActivity.DetailActivity
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(DetailActivityModule::class, RandomUsersModule::class))
interface DetailActivityComponent {

    fun injectMainActivity(activity: DetailActivity)
    fun getRandomUsersApi(): RandomUsersApi
}