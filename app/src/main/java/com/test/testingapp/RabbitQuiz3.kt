package com.test.testingapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.test.testingapp.databinding.ActivityRabbitQuiz3Binding
import com.test.testingapp.HomeFragment as HomeFragment

class RabbitQuiz3 : AppCompatActivity() {

    private lateinit var binding: ActivityRabbitQuiz3Binding
    private var selectedAnswer: RadioButton? = null
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRabbitQuiz3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize MediaPlayer with the sound resource
        mediaPlayer = MediaPlayer.create(this, R.raw.next_sound)

        // Handle back button click
        binding.backArrow.setOnClickListener {
            onBackPressed()
        }

        // Handle radio button selection
        binding.answerGroup.setOnCheckedChangeListener { group, checkedId ->
            selectedAnswer = findViewById(checkedId)
            binding.next.isEnabled = selectedAnswer != null
        }

        // Handle Next button click
        binding.next.setOnClickListener {
            if (selectedAnswer != null) {
                // Play the sound
                mediaPlayer.start()

                val intent = Intent(this, RabbitQuiz4::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle bottom navigation clicks
        binding.navHome.setOnClickListener {
            loadFragment(HomeFragment())
        }

        binding.navQuiz.setOnClickListener {
            loadFragment(QuizFragment())
        }

        binding.navProfile.setOnClickListener {
            loadFragment(ProfileFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}
