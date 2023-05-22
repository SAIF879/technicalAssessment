package com.example.technicalassessment.screens.home.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.technicalassessment.R
import com.example.technicalassessment.databinding.FragmentLinksBinding


class LinksFragment : Fragment() {
    private val binding by lazy { FragmentLinksBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return binding.root
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bad.setBackgroundResource(R.drawable.card_border)


    }

}