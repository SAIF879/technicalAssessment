package com.example.technicalassessment.screens.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.technicalassessment.R
import com.example.technicalassessment.databinding.FragmentCampaignsBinding


class CampaignsFragment : Fragment() {
    private val binding by lazy {FragmentCampaignsBinding.inflate(layoutInflater)}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_campaigns, container, false)
    }

}