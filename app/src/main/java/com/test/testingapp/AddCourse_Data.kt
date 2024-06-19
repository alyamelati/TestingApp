package com.test.testingapp

import kotlin.collections.ArrayList

object AddCourse_Data {
    fun getCourseData(): ArrayList<Courses_Data>{
        val courseList = ArrayList<Courses_Data>()
        val course1=Courses_Data("Herbivore", "Panda", R.drawable.baby_panda, "https://youtu.be/d6YeB3mRFyk?si=-ssofrrqB_IRs2QJ")
        courseList.add(course1)
        val course2=Courses_Data("Herbivore", "Koala", R.drawable.baby_koala, "https://youtu.be/d6YeB3mRFyk?si=-ssofrrqB_IRs2QJ")
        courseList.add(course2)
        val course3=Courses_Data("Herbivore", "Elephant", R.drawable.baby_elephant, "https://youtu.be/d6YeB3mRFyk?si=-ssofrrqB_IRs2QJ")
        courseList.add(course3)
        return courseList
    }
}