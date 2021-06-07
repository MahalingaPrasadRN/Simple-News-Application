package com.mahlingaprasad.newsapp.models

data class News(val articles: ArrayList<NewsDetails>)
data class NewsDetails(val title : String, val description : String, val urlToImage : String, val url:String)