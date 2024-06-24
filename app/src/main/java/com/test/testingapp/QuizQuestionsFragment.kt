package com.test.testingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.test.testingapp.model.Quiz

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizQuestionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizQuestionsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var data: Quiz? = null //variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.getSerializable("QUIZ") as Quiz?;
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_quiz_questions, container, false)

        var pertanyaan: TextView = view.findViewById<TextView>(R.id.questions) //value
        pertanyaan.text = data?.soal

        return view

        // TO-DO
    }

}