package com.example.haberler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val headingNews:TextView=findViewById(R.id.heading)
        val mainNews:TextView=findViewById(R.id.news)
        val imageNews:ImageView=findViewById(R.id.image_heading)

        val bundle:Bundle?= intent.extras
        val heading=bundle!!.getString("heading")
        val imageId=bundle!!.getInt("imageId")
        val news=bundle!!.getString("news")

        headingNews.text=heading
        mainNews.text=news
        imageNews.setImageResource(imageId)


    }
}