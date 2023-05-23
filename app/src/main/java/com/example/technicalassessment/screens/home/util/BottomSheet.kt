package com.example.technicalassessment.screens.home.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.technicalassessment.R
import com.example.technicalassessment.databinding.FragmentBottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheet : BottomSheetDialogFragment(){

    private val binding by lazy { FragmentBottomsheetBinding.inflate(layoutInflater) }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.fragment_bottomsheet, container, false)

        }
    }
