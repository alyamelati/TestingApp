 package com.test.testingapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

 // TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
 private const val arg_quizTitle: String = "quizTitle"
 private const val arg_quizImage = "quizImage"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment()/*, Adapter_Quiz.onItemClickListener*/ {
    private lateinit var recyclerView: RecyclerView
    private lateinit var coursesAdapter: Adapter_Courses
    private var list = ArrayList<Quiz_Data>()

    private lateinit var quizTitle: Array<String>
    private lateinit var quizImage: Array<Int>

    private var quiz_title: String? = null
    private var quiz_image: String? = null
    /* private var course_link: String? = null*/

    /*private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*val layoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = layoutManager*/
        arguments?.let {
            quiz_title = it.getString(arg_quizTitle)
            quiz_image= it.getString(arg_quizImage)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        /*val LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = LayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        coursesAdapter = Adapter_Courses(this, list)
        recyclerView.adapter = coursesAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        list.add("Herbivore", "Panda", "@drawable/baby_panda", "https://youtu.be/d6YeB3mRFyk?si=-ssofrrqB_IRs2QJ")
*/
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(quiz_title: String, quiz_image: String) = QuizFragment().apply {
            arguments = Bundle().apply {
                putString(arg_quizTitle, quiz_title)
                putString(arg_quizImage, quiz_image)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val quizList = AddQuiz_Data.getQuizData()
        val itemAdapter = Adapter_Quiz(quizList)

        val recyclerView: RecyclerView = view.findViewById(R.id.quiz_list)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = itemAdapter
    }

    /*private fun signoutUser(){
        auth.signOut()
        startActivity(Intent(context, Login::class.java))
    }*/

    /*override fun onItemClick(position: Int) {
        when(position){
            0 -> startActivity(Intent(requireContext(), Video_Learning::class.java))
            1 -> startActivity(Intent(requireContext(), Video_Learningkoala::class.java))
            2 -> startActivity(Intent(requireContext(), Video_Learningelephant::class.java))
            3 -> startActivity(Intent(requireContext(), Video_Learningrabbit::class.java))
        }
    }*/
}