package com.example.technicalassessment.screens.home.util

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.technicalassessment.databinding.HorizontalItemBinding
import com.example.technicalassessment.screens.home.model.RvModal

class HomeScreenAdapter(private val items : List<RvModal>)  : RecyclerView.Adapter<HomeScreenAdapter.HomeViewHolder>() {

    private val cardColors = arrayOf("#1F5C33CF", "#1F0E6FFF", "#0000FF", "#1Fffff00")
    class  HomeViewHolder(val binding: HorizontalItemBinding ) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeScreenAdapter.HomeViewHolder{
        return HomeViewHolder(HorizontalItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
      val item=items[position]
        holder.binding.tvDataValue.text=item.content
        holder.binding.tvDataTheme.text=item.title
        holder.binding.ivCard.setImageResource(item.img)
        val color = Color.parseColor(cardColors[position % cardColors.size])
    }

    override fun getItemCount(): Int {
     return items.size
    }




}
