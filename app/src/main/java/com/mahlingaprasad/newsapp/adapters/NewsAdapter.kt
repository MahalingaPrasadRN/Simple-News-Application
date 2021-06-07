package com.mahlingaprasad.newsapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mahlingaprasad.newsapp.MainActivity
import com.mahlingaprasad.newsapp.R
import com.mahlingaprasad.newsapp.WebViewActivity
import com.mahlingaprasad.newsapp.models.NewsDetails
import com.squareup.picasso.Picasso

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    var articles = ArrayList<NewsDetails>()
    lateinit var context: Context

    fun setUpdatedData(articles: ArrayList<NewsDetails>, context: Context){
        this.articles = articles
        this.context = context
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        val newsImage = view.findViewById<ImageView>(R.id.newsImage)
        val newsHeading = view.findViewById<TextView>(R.id.newsHeading)
        val newsDescription = view.findViewById<TextView>(R.id.newsDescription)
        val cardView = view.findViewById<CardView>(R.id.cardView)
        fun  bind(data : NewsDetails){
            newsHeading.text = data.title
            newsDescription.text = data.description
            
            val imageUrl : String  = data.urlToImage
            
            Picasso.get()
                .load(imageUrl)
                .into(newsImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(articles.get(position))

        holder.newsImage.setOnClickListener(View.OnClickListener { v-> gotoWebview(articles.get(position)) })
        holder.newsDescription.setOnClickListener(View.OnClickListener { v-> gotoWebview(articles.get(position)) })
        holder.newsHeading.setOnClickListener(View.OnClickListener { v-> gotoWebview(articles.get(position)) })
        holder.cardView.setOnClickListener(View.OnClickListener { v-> gotoWebview(articles.get(position)) })
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    private fun gotoWebview(data : NewsDetails){
        val intent = Intent (context, WebViewActivity::class.java)
        intent.putExtra("url", data.url)
        context.startActivity(intent)
    }
}