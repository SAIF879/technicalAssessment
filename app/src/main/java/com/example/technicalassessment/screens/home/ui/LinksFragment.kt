package com.example.technicalassessment.screens.home.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentapp.networkService.ApiResult
import com.example.assignmentapplisted.home.data.OpenInDAO
import com.example.technicalassessment.R
import com.example.technicalassessment.databinding.FragmentLinksBinding
import com.example.technicalassessment.screens.home.model.RvModal
import com.example.technicalassessment.screens.home.util.HomeScreenAdapter
import com.example.technicalassessment.screens.home.util.HomeViewModel


class LinksFragment : Fragment() {
    private val binding by lazy { FragmentLinksBinding.inflate(layoutInflater) }
    private val viewModel : HomeViewModel by activityViewModels()
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
        viewModel.getHomeData()
        viewModel.homeData.observe(requireActivity()){
            when(it){
                ApiResult.Loading->{
                    Toast.makeText(requireContext(),"loading",Toast.LENGTH_SHORT).show()
                }
                is ApiResult.Success->{
                    val data=it.data as OpenInDAO
                    val list= listOf(RvModal(R.drawable.add_icon,"Total Clicks",data.totalClicks.toString()),
                        RvModal(R.drawable.search_icon,"Location",data.topLocation.toString())
                        ,RvModal(R.drawable.boost_icon,"sdfdf","dedfsdfsdfsdffsf"))
                    binding.rvData.layoutManager=LinearLayoutManager(requireContext())
                    binding.rvData.adapter=HomeScreenAdapter(list)
                }
                is ApiResult.Error->{
                    Toast.makeText(requireContext(),"error ${it.message}",Toast.LENGTH_SHORT).show()
                }
            }
        }



    }

}