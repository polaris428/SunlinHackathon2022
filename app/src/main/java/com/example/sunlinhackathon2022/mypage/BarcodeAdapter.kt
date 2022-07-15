package com.example.sunlinhackathon2022.mypage

import android.graphics.Bitmap
import android.graphics.Color.BLACK
import android.graphics.Color.WHITE
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.sunlinhackathon2022.databinding.ItemBarcodeListBinding

import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix


class BarcodeAdapter: RecyclerView.Adapter<BarcodeAdapter.Holder>() {
    var listData = mutableListOf<BarcodeList>()
    class Holder(val binding: ItemBarcodeListBinding) : RecyclerView.ViewHolder(binding.root){
        fun setData(barcodeList: BarcodeList){
            binding.barcodeTextView.text=barcodeList.barcode[position].name

            val barcode= createBarcode(barcodeList.barcode[position].barcode, binding)
           binding.barcodeImageView.setImageBitmap(barcode)

        }

        fun createBarcode(code: String,binding: ItemBarcodeListBinding) : Bitmap {
            val widthPx = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 390f,
                binding.root.resources.displayMetrics
            )
            val heightPx = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 111f,
                binding.root.resources.displayMetrics
            )
            val format: BarcodeFormat = BarcodeFormat.CODE_128
            val matrix: BitMatrix = MultiFormatWriter().encode(code, format, widthPx.toInt(), heightPx.toInt())
            val bitmap = createBitmap(matrix)
            return bitmap
        }

        fun createBitmap(matrix: BitMatrix): Bitmap {
            val width = matrix.width
            val height = matrix.height
            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setPixel(x, y, if (matrix.get(x, y)) BLACK else WHITE)
                }
            }
            return bitmap
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBarcodeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BarcodeAdapter.Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val shopData = listData[position]
        holder.setData(shopData)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
    private val WHITE: Int = 0xFFFFFFFF.toInt()
    private val BLACK: Int = 0xFF000000.toInt()



}