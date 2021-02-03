package com.example.itunessongsearch.service

import android.provider.MediaStore
import com.example.itunessongsearch.ItunesResponse
import com.example.itunessongsearch.model.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitInterface {

    @GET("/search")
    fun getSongs(@Query("term") artist: String) : Call<ItunesResponse>


}