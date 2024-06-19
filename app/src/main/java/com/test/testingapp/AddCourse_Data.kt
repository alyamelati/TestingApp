package com.test.testingapp

import kotlin.collections.ArrayList

object AddCourse_Data {
    fun getCourseData(): ArrayList<Courses_Data>{
        val courseList = ArrayList<Courses_Data>()
        val course1=Courses_Data("Herbivore", "Panda", R.drawable.baby_panda, R.layout.activity_video_learning)
        courseList.add(course1)
        val course2=Courses_Data("Herbivore", "Koala", R.drawable.baby_koala, R.layout.activity_video_learning)
        courseList.add(course2)
        val course3=Courses_Data("Herbivore", "Elephant", R.drawable.baby_elephant, R.layout.activity_video_learning)
        courseList.add(course3)
        val course4=Courses_Data("Herbivore", "Rabbit", R.drawable.baby_rabbit, R.layout.activity_video_learning)
        courseList.add(course4)
        return courseList
    }
}