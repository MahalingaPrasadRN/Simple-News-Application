package com.mahlingaprasad.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahlingaprasad.newsapp.models.News
import com.mahlingaprasad.newsapp.network.RetroService
import com.mahlingaprasad.newsapp.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

    private const val tesla = "tesla"
    private const val date = "2021-05-23"
    private const val from = "publishedAt"
    private const val api = "cdbc8cc82eb84568993a12d7ab0dfaf5"

class MainActivityViewModel: ViewModel() {
    var newsLiveData: MutableLiveData<News> = MutableLiveData()

    fun getNewsLiveDataObserver(): MutableLiveData<News> {
        return newsLiveData
    }

    fun  makeApiCall(){
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetrofitInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromAPI(tesla, date, from, api)
            newsLiveData.postValue(response)
        }
    }
}