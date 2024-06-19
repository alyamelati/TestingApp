package com.test.testingapp

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.test.testingapp.databinding.FragmentHomeBinding
import kotlin.collections.ArrayList

private const val arg_courseCateg: String = "courseCategory"
private const val arg_courseTitle: String = "courseTitle"
private const val arg_courseImage = "courseImage"

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var coursesAdapter: Adapter_Courses
    private var list = ArrayList<Courses_Data>()
    private lateinit var courseCategory: Array<String>
    private lateinit var courseTitle: Array<String>
    private lateinit var courseImage: Array<Int>

    private var course_categ: String? = null
    private var course_title: String? = null
    private var course_image: String? = null
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
            course_categ = it.getString(arg_courseCateg)
            course_title = it.getString(arg_courseTitle)
            course_image= it.getString(arg_courseImage)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        /*recyclerView = view.findViewById(R.id.courses_list)

        val LayoutManager = LinearLayoutManager(context)
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
        fun newInstance(course_categ: String, course_title: String) = HomeFragment().apply {
            arguments = Bundle().apply {
                putString(arg_courseCateg, course_categ)
                putString(arg_courseTitle, course_title)
                putString(arg_courseImage, course_image)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val courseList = AddCourse_Data.getCourseData()
        val itemAdapter = Adapter_Courses(courseList)

        val recyclerView: RecyclerView = view.findViewById(R.id.courses_list)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = itemAdapter
    }
}