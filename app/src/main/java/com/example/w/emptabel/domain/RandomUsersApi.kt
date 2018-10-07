package com.example.w.emptabel.domain

import com.example.w.emptabel.Model.Customer
import com.example.w.emptabel.Model.Customers
import retrofit2.Call
import retrofit2.http.GET

interface RandomUsersApi {

    @GET("api/17229ded0a7ac0640428d02f82deeb4e")
    fun getRandomUsers(): Call<Customers>
}