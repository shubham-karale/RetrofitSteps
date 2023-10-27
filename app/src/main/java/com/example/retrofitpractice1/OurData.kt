package com.example.retrofitpractice1

data class OurData(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)