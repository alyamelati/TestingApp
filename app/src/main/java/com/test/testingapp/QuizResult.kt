package com.test.testingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.test.testingapp.databinding.ActivityQuizResultBinding

class QuizResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle back button click
        binding.backArrow.setOnClickListener {
            finish() // Go back to previous activity (or fragment)
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

        // Show congratulatory message based on quiz result (for demonstration purpose)
        // You can customize this based on actual result obtained
        val message = "You got 100% of the\nquestions correct. \nCongratulations!"
        binding.message.text = message
    }

    private fun navigateToFragment(fragment: Fragment) {
        // You would typically replace this with your own navigation logic
        // For demonstration, this just finishes the current activity
        finish()
    }
}
