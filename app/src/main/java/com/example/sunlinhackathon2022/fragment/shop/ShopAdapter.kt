package com.example.sunlinhackathon2022.fragment.shop

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sunlinhackathon2022.MainActivity
import com.example.sunlinhackathon2022.databinding.ItemShopBinding


class ShopAdapter : RecyclerView.Adapter<ShopAdapter.Holder>() {
    var listData = mutableListOf<shopItem>()
    var mContext: Context? =null
    lateinit var name1:String
    lateinit var name2:String
    lateinit var category1:String
    lateinit var category2:String
    lateinit var photo1:String
    lateinit var photo2:String

    class Holder(val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(shopItem: shopItem){
            binding.root.context
            binding.firstTitle.text=shopItem.name1
            binding.SecondTitle.text=shopItem.name2
            binding.firstTag.text=shopItem.category1
            binding.secondTag.text=shopItem.category2
            binding.firstCost.text=shopItem.category2
            Glide.with(binding.root).load(shopItem.photo1).centerCrop().into(binding.firstImage)
            Glide.with(binding.root).load(shopItem.photo2).centerCrop().into(binding.SecondImage)

            binding.goods1.setOnClickListener {
                var intent=Intent(binding.root.context,ProductDetailsActivity::class.java)
                intent.putExtra("name",shopItem.name1)
                intent.putExtra("tag",shopItem.category1)
                intent.putExtra("photo",shopItem.photo1)
                intent.putExtra("description",shopItem.description1)
                intent.putExtra("price",shopItem.price1)
                binding.root.context.startActivity(intent)
            }
            binding.goods2.setOnClickListener {
                var intent=Intent(binding.root.context,ProductDetailsActivity::class.java)
                intent.putExtra("name",shopItem.name1)
                intent.putExtra("tag",shopItem.category1)
                intent.putExtra("photo",shopItem.photo1)
                intent.putExtra("description",shopItem.description1)
                intent.putExtra("price",shopItem.price2)
                binding.root.context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(binding)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val shopItem = listData[position]
        holder.setData(shopItem)

    }

    override fun getItemCount(): Int {
        return listData.size
    }
}