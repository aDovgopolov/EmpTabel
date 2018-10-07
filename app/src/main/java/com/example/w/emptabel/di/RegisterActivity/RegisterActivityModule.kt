package com.example.w.emptabel.di.RegisterActivity

import com.example.w.emptabel.AppConfig
import com.example.w.emptabel.domain.RegisterUserApi
import com.example.w.emptabel.ui.registerActivity.RegisterActivityPresenter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module (includes = arrayOf(OkHttpClientModule::class))
class RegisterActivityModule {

    @Singleton
    @Provides
    fun provideRegisterActivityPresenter(): RegisterActivityPresenter {
        return RegisterActivityPresenter()
    }

    @Provides
    fun randomUsersApi(retrofit: Retrofit): RegisterUserApi {
        return retrofit.create(RegisterUserApi::class.java!!)//retrofit.create<RandomUsersApi>(RandomUsersApi::class.java!!)
    }

    @Singleton
    @Provides
    fun retrofit(//okHttpClient: OkHttpClient,
             gsonConverterFactory: GsonConverterFactory, gson: Gson): Retrofit {
        return Retrofit.Builder()
                //.client(okHttpClient)
                .baseUrl(AppConfig.URL_REGISTER_RETROFIT)
                .addConverterFactory(gsonConverterFactory)
                .build()
    }

    @Provides
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

}