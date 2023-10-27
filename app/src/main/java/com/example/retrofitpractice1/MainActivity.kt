package com.example.retrofitpractice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recylerView:RecyclerView

    lateinit var productAdapter: ProductAdapter

//    Don't Create the productList var as ArrayList direct create variables

//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recylerView = findViewById(R.id.recylerView)

//        TODO: Create the Retrofit Builder

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dummyjson.com")
            .build()
            .create(ApiInterface::class.java)

//        TODO: Create the retrofit Data
        val retrofitData = retrofitBuilder.getProductsData();

//        TODO: Send the retrofit Data
        retrofitData.enqueue(object : Callback<OurData?> {
            override fun onResponse(call: Call<OurData?>, response: Response<OurData?>) {
//                TODO: Check the response is success or not
                val responseBody = response.body()!!
//              TODO: Create the productList as variable and then directly assign the responseBody.products
                val productList = responseBody.products

//  While sending productList to ProductAdapter we pass the directly data class in which all the data is present

//                Suppose we have a data class Product pass the productList = List<Product> in ProductAdapter

                productAdapter = ProductAdapter(this@MainActivity,productList)

                recylerView.adapter = productAdapter

                recylerView.layoutManager = LinearLayoutManager(this@MainActivity)

            }

            override fun onFailure(call: Call<OurData?>, t: Throwable) {
               Log.d("MainActivity","onFailure: "+t.message)
            }
        })



    }
}