package com.example.w.emptabel.di.DetailActivity

import com.example.w.emptabel.ui.detailActivity.DetailActivityPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DetailActivityModule {

    @Singleton
    @Provides
    fun provideDetailActivityPresenter(): DetailActivityPresenter {return DetailActivityPresenter()
    }

}