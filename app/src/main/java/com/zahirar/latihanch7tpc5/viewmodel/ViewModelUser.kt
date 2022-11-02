package com.zahirar.latihanch7tpc5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zahirar.latihanch7tpc5.model.PostDataUser
import com.zahirar.latihanch7tpc5.network.RetrofitClient
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser : ViewModel() {

    lateinit var addLiveDataUser : MutableLiveData<PostDataUser>

    init {
        addLiveDataUser = MutableLiveData()
    }

    fun postLiveDataUser() : MutableLiveData<PostDataUser> {
        return addLiveDataUser
    }

    fun postApiUser(full_name: RequestBody, email : RequestBody, password : RequestBody, phone_number : RequestBody, address : RequestBody, fileImage : MultipartBody.Part, city : RequestBody){
        RetrofitClient.instance.registerAccount(full_name, email, password, phone_number, address, fileImage, city)
            .enqueue(object : Callback<PostDataUser> {
                override fun onResponse(
                    call: Call<PostDataUser>,
                    response: Response<PostDataUser>
                ) {
                    if (response.isSuccessful){
                        addLiveDataUser.postValue(response.body())
                    }else{
                        addLiveDataUser.postValue(null)
                    }

                }

                override fun onFailure(call: Call<PostDataUser>, t: Throwable) {
                    addLiveDataUser.postValue(null)
                }

            })
    }

}