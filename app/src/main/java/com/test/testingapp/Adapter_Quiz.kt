package com.test.testingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

public class Adapter_Quiz(private val list: ArrayList<Quiz_Data>, val mlistener: onItemClickListener): RecyclerView.Adapter<Adapter_Quiz.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val quiz_title: TextView = view.findViewById(R.id.quiz_title)
        val quiz_image: ImageView = view.findViewById(R.id.quiz_image)

        init {
            view.setOnClickListener{
                val position = adapterPosition
                mlistener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.quiz_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.quiz_title.text = list[position].quiz_title
        holder.quiz_image.setImageResource(list[position].quiz_image)
    }

    interface onItemClickListener {
        fun onItemClick(position: Int){

        }
    }
}