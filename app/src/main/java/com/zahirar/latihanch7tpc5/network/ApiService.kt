package com.zahirar.latihanch7tpc5.network

import com.zahirar.latihanch7tpc5.model.PostDataUser
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @POST("auth/register")
    @Multipart
    fun registerAccount(
        @Part("full_name") full_name: RequestBody,
        @Part("email") email : RequestBody,
        @Part("password") password : RequestBody,
        @Part("phone_number") phone_number : RequestBody,
        @Part("address") address : RequestBody,
        @Part fileImage : MultipartBody.Part,
        @Part("city") city : RequestBody
    ): Call<PostDataUser>

}