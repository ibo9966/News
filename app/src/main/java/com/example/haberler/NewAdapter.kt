package com.example.haberler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class NewAdapter(private val newsList:ArrayList<News>): RecyclerView.Adapter<NewAdapter.NewViewHolder>() {

    private lateinit var mListener:onItemClickListener

    interface  onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return NewViewHolder(itemView,mListener)

    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text=currentItem.heading
    }

    override fun getItemCount(): Int {

        return newsList.size
    }

    class NewViewHolder(itemView : View,listener :onItemClickListener):RecyclerView.ViewHolder(itemView){


        val titleImage : ShapeableImageView=itemView.findViewById(R.id.title_image)
        val tvHeading:TextView=itemView.findViewById(R.id.tvHeading)

        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }
    }
}