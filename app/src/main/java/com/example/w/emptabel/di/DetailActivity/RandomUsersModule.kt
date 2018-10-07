package com.example.w.emptabel.di.DetailActivity

import com.example.w.emptabel.domain.RandomUsersApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RandomUsersModule {

    @Singleton
    @Provides
    fun randomUserApi(retrofit: Retrofit): RandomUsersApi {
        return retrofit.create(RandomUsersApi::class.java)
    }

    @Singleton
    @Provides
    fun retrofit(gsonConverterFactory: GsonConverterFactory, gson: Gson): Retrofit{
        return Retrofit.Builder()
                .baseUrl("https://randomapi.com/")
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