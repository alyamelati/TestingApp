package com.test.testingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.test.testingapp.databinding.ActivityQuizResultBinding

class QuizResult : AppCompatActivity() {

    private lateinit var binding: ActivityQuizResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        binding = ActivityQuizResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle back button click
        binding.backArrow.setOnClickListener {
            finish() // Go back to previous activity (or fragment)
        }

        // Handle bottom navigation clicks
        loadFragment(HomeFragment())
        var bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.navigation_quiz -> {
                    loadFragment(QuizFragment())
                    true
                }
                else -> {
                    loadFragment(HomeFragment())
                    true
                }
            }
        }

        // Show congratulatory message based on quiz result (for demonstration purpose)
        // You can customize this based on actual result obtained
        val message = "You got 100% of the\nquestions correct. \nCongratulations!"
        binding.message.text = message
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

//    private fun navigateToFragment(fragment: Fragment) {
//        // You would typically replace this with your own navigation logic
//        // For demonstration, this just finishes the current activity
//        finish()
//    }
}
