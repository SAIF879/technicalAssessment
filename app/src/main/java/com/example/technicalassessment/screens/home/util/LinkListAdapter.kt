package com.example.technicalassessment.screens.home.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.technicalassessment.databinding.HorizontalItemBinding
import com.example.technicalassessment.databinding.ListItemBinding

class LinkListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    class ListViewHolder(val binding :ListItemBinding ) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):LinkListAdapter.ListViewHolder {
        return ListViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent , false))
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}