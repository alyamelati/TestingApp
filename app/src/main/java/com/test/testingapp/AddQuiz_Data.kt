package com.test.testingapp

import kotlin.collections.ArrayList

object AddQuiz_Data {
    fun getQuizData(): ArrayList<Quiz_Data>{
        val quizlist = ArrayList<Quiz_Data>()
        val quiz1=Quiz_Data("Panda", R.drawable.baby_panda)
        quizlist.add(quiz1)
        val quiz2=Quiz_Data("Koala", R.drawable.baby_koala)
        quizlist.add(quiz2)
        val quiz3=Quiz_Data("Elephant", R.drawable.baby_elephant)
        quizlist.add(quiz3)
        val quiz4=Quiz_Data("Rabbit", R.drawable.baby_rabbit)
        quizlist.add(quiz4)
        return quizlist
    }
}