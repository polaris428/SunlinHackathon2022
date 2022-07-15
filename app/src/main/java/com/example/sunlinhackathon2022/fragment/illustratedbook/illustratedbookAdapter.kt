package com.example.sunlinhackathon2022.fragment.illustratedbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sunlinhackathon2022.AnimalDetailActivity
import com.example.sunlinhackathon2022.databinding.ItemDictionaryBinding



class illustratedbookAdapter : RecyclerView.Adapter<illustratedbookAdapter.Holder>(){
    var listData = mutableListOf<illustratedBookData>()
    class Holder(val binding: ItemDictionaryBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(illustratedBookData: illustratedBookData){
            binding.root.context
            binding.animalName.text=illustratedBookData.name
            Glide.with(binding.root.context)
                .load(illustratedBookData.uri)
                .into(binding.animalImageView)
            binding.animalImageView.setOnClickListener {
                val nameList = listOf("대왕판다","너구리","사슴","늑대","백상아리","바다거북","악어","호랑이")
                val animalId = nameList.indexOf(illustratedBookData.name) + 1
                val detailIntent = Intent(binding.root.context, AnimalDetailActivity::class.java)
                detailIntent.putExtra("animalCode",animalId)
                binding.root.context.startActivity(detailIntent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemDictionaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return illustratedbookAdapter.Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val illustratedBookData = listData[position]
        holder.setData(illustratedBookData)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}