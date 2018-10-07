package com.example.w.emptabel.domain

import com.example.w.emptabel.ui.registerActivity.RegistrationResponse
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.POST

interface RegisterUserApi {

    //localhost only
    @FormUrlEncoded
    @HTTP(method = "POST", path = "android_login_api/register.php", hasBody = true)
    fun registerRandomUsers(@Field("name") name:String,
                            @Field("email") email:String,
                            @Field("password") password:String )
            : Call<RegistrationResponse>

    @GET("android_login_api/register.php")
    fun getRegisterRandomUsers(@Query("name") name: String, @Query("email") email: String, @Query("password") password: String)
            : Call<RegistrationResponse>

    @POST("android_login_api/register.php")
    fun registerEmptyUsers(): Call<RegistrationResponse> // List<PostModel>
}