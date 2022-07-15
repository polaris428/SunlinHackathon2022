package com.example.sunlinhackathon2022.fragment.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sunlinhackathon2022.databinding.ItemShopBinding

class ShopAdapter : RecyclerView.Adapter<ShopAdapter.Holder>() {
    var listData = mutableListOf<ShopData>()

    class Holder(val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(shopData: ShopData){
            binding.firstTitle.text=shopData.shopItem[position].name1
            binding.SecondTitle.text=shopData.shopItem[position].name2
            binding.firstTag.text=shopData.shopItem[position].category1
            binding.secondTag.text=shopData.shopItem[position].category2

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val shopData = listData[position]
        holder.setData(shopData)

    }

    override fun getItemCount(): Int {
        return listData.size
    }
}