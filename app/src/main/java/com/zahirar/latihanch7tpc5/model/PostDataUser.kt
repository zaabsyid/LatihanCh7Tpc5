package com.zahirar.latihanch7tpc5.model

import com.google.gson.annotations.SerializedName

data class PostDataUser(

    @SerializedName("full_name")
    val full_name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone_number")
    val phone_number: Int,
    @SerializedName("address")
    val address: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("city")
    val city: String
)
