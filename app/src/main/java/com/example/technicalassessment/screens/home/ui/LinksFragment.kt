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
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentapp.networkService.ApiResult
import com.example.assignmentapplisted.home.data.OpenInDAO
import com.example.technicalassessment.R
import com.example.technicalassessment.databinding.FragmentLinksBinding
import com.example.technicalassessment.screens.home.model.RvModal
import com.example.technicalassessment.screens.home.util.HomeScreenAdapter
import com.example.technicalassessment.screens.home.util.HomeViewModel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import java.util.Locale


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
        binding.tvGreeting.text = localGreeting()
        binding.rvData.layoutManager = LinearLayoutManager(requireContext()).apply {
            orientation = LinearLayoutManager.HORIZONTAL}
            viewModel.homeData.observe(requireActivity()) {
                when (it) {
                    ApiResult.Loading -> {
//                        Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                        //show progress Bar
                    }

                    is ApiResult.Success -> {
                        val data = it.data as OpenInDAO
                        val list = listOf(
                            RvModal(
                                R.drawable.add_icon,
                                "Total Clicks",
                                data.totalClicks.toString()
                            ),
                            RvModal(
                                R.drawable.search_icon,
                                "Location",
                                data.topLocation.toString()
                            ),
                            RvModal(R.drawable.boost_icon, "Top Source", data.topSource.toString()),
                            RvModal(R.drawable.search_icon, "Best Time", data.startTime.toString())
                        )
                        binding.rvData.adapter = HomeScreenAdapter(list)
                    }

                    is ApiResult.Error -> {
                        Toast.makeText(requireContext(), "error ${it.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }





        }


    private fun localGreeting() : String{
    val currentTime = Date()
        val timeFormat = SimpleDateFormat("HH", Locale.getDefault())
        val hour = timeFormat.format(currentTime).toInt()

        return when(hour){
            in 0..11 -> "Good Morning"
            in 12..16 -> "Good AfterNoon"
            in 17..20 -> "Good Evening"
            else -> "Good Night"
        }
    }

    }