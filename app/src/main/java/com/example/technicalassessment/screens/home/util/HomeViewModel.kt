package com.example.technicalassessment.screens.home.util

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentapp.networkService.ApiResult
import com.example.assignmentapplisted.home.data.OpenInDAO
import com.example.technicalassessment.screens.home.model.RvLinkModalClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    private val _homeData = MutableLiveData<ApiResult<OpenInDAO>>()
     val homeData : MutableLiveData<ApiResult<OpenInDAO>>
     get() = _homeData

    fun getHomeData() {
        homeData.value = ApiResult.Loading
        viewModelScope.launch {
            _homeData.value = repository.getData()
        }
    }

    private val _state = MutableLiveData<Int>()
    val state : MutableLiveData<Int>
        get() = _state
    fun setState(i:Int){
        _state.value=i
        when(state.value){
            1->{
                setListDataRecent()
            }
            2->{
                setListDataTop()
            }
        }
    }

    private val _listData = MutableLiveData<List<RvLinkModalClass>>()
    val listData : MutableLiveData<List<RvLinkModalClass>>
        get() = _listData
    private fun setListDataRecent(){
        val list= homeData.value?.data as OpenInDAO
        val newList=ArrayList<RvLinkModalClass>()
        for (item in list.data?.recentLinks!!){
            newList.add(RvLinkModalClass(item.originalImage.toString(),item.title.toString(),item.createdAt.toString(),item.totalClicks.toString(),item.webLink.toString()))
        }
        _listData.value=newList
    }
    fun setListDataTop(){
        val list= homeData.value?.data as OpenInDAO
        val newList=ArrayList<RvLinkModalClass>()
        for (item in list.data?.topLinks!!){
            newList.add(RvLinkModalClass(item.originalImage.toString(),item.title.toString(),item.createdAt.toString(),item.totalClicks.toString(),item.webLink.toString()))
        }
        _listData.value=newList
    }

}