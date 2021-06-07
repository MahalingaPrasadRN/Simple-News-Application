package com.mahlingaprasad.newsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahlingaprasad.newsapp.R
import com.mahlingaprasad.newsapp.adapters.NewsAdapter
import com.mahlingaprasad.newsapp.models.News
import com.mahlingaprasad.newsapp.viewmodel.MainActivityViewModel
import java.lang.Exception

class NewsFragment : Fragment() {

    private lateinit var recyclerAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_news, container, false)

        initViewModel(view)
        initViewModel()
        return view
    }

    private fun  initViewModel(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)
        recyclerAdapter = NewsAdapter()
        recyclerView.adapter = recyclerAdapter
    }

    private fun initViewModel() {
        try {
            val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
            viewModel.getNewsLiveDataObserver().observe(this, Observer<News> {
                if (it != null) {
                    recyclerAdapter.setUpdatedData(it.articles, context!!)
                } else {
                    Toast.makeText(activity, "Error in getting data!", Toast.LENGTH_SHORT).show()
                }
            })
            viewModel.makeApiCall()
        }catch (e: Exception){
            Toast.makeText(activity, e.toString(), Toast.LENGTH_LONG).show()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            NewsFragment()
    }
}