package com.test.testingapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.test.testingapp.databinding.ActivityQuizResultBinding

class QuizResult : AppCompatActivity() {

    private lateinit var binding: ActivityQuizResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null){
            supportActionBar!!.hide()
        }

        // Handle back button click
        binding.backArrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("TAB", "QUIZ")
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) //menghapus semua halaman sebelum quiz5
            startActivity(intent)

        }

        // Handle bottom navigation clicks
        binding.navHome.setOnClickListener {
            navigateToFragment(HomeFragment())
        }

        binding.navQuiz.setOnClickListener {
            navigateToFragment(QuizFragment())
        }

        binding.navProfile.setOnClickListener {
            navigateToFragment(ProfileFragment())
        }


        val message = "You got 100% of the\nquestions correct. \nCongratulations!"
        binding.message.text = message
    }

    private fun navigateToQuizFragment() {
        val quizFragment = QuizFragment()
        supportFragmentManager.commit {
            replace(R.id.fragment_container, quizFragment)
            addToBackStack(null)
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }
    }
}
