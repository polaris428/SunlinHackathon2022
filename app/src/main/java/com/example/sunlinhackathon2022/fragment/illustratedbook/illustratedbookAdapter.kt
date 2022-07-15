package com.example.sunlinhackathon2022.fragment.illustratedbook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sunlinhackathon2022.databinding.ItemIllustratedbookBinding


class illustratedbookAdapter : RecyclerView.Adapter<illustratedbookAdapter.Holder>(){
    var listData = mutableListOf<illustratedBookData>()
    class Holder(val binding: ItemIllustratedbookBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(illustratedBookData: illustratedBookData){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemIllustratedbookBinding.inflate(LayoutInflater.from(parent.context), parent, false)

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