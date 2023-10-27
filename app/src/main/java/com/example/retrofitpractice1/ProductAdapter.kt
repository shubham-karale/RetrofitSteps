package com.example.retrofitpractice1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


//While sending productList to ProductAdapter we pass the directly data class in which all the data is present
//
////                Suppose we have a data class Product pass the productList = List<Product> in ProductAdapter

class ProductAdapter(val context:Activity,val productList:List<Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        val productImage = itemView.findViewById<ImageView>(R.id.productImage)

        val productName = itemView.findViewById<TextView>(R.id.productName)

        val productPrice = itemView.findViewById<TextView>(R.id.productPrice)

        val productRating = itemView.findViewById<TextView>(R.id.productRating)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.each_row,parent,false)
        return ProductViewHolder(view)

    }

    override fun getItemCount(): Int {
       return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

//holder.productName.text = productList[position].productName
//        holder.productPrice.text = productList[position].productPrice
//        holder.productRating.text = productList[position].productRating
//        Picasso.get().load(productList[position].productImage).into(holder.productImage)

        val currentProduct = productList[position]

        holder.productName.text = currentProduct.title

        holder.productPrice.text = currentProduct.price.toString()

        holder.productRating.text = currentProduct.rating.toString()

        Picasso.get().load(currentProduct.thumbnail).into(holder.productImage)



    }


}