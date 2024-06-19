package com.test.testingapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

public class Adapter_Courses(private val list: ArrayList<Courses_Data>): RecyclerView.Adapter<Adapter_Courses.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val course_category: TextView = view.findViewById(R.id.category_course)
        val course_title: TextView = view.findViewById(R.id.title_course)
        val course_image: ImageView = view.findViewById(R.id.course_image)
        /*val courseLayout: LinearLayout = view.findViewById(R.id.item_course)*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.courses_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.course_category.text = list[position].category_title
        holder.course_title.text = list[position].course_title
        holder.course_image.setImageResource(list[position].course_image)
        /*holder.courseLayout.setOnClickListener {
            context.startActivity(Intent(context, Video_Learning::class.java))
        }*/
    }
}