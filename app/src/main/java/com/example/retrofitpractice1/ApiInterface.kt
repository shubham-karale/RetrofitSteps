package com.example.retrofitpractice1

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")

    fun getProductsData(): Call<OurData>



}