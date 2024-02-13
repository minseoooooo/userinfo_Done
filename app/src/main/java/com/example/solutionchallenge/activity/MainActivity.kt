package com.example.solutionchallenge.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.example.solutionchallenge.R
import com.example.solutionchallenge.RecommendationOfTodayDialog
import com.example.solutionchallenge.databinding.ActivityMainBinding
import com.example.solutionchallenge.databinding.FragmentRecommendListBinding

import com.example.solutionchallenge.datamodel.Exercise
import com.example.solutionchallenge.datamodel.exerciseList
import com.example.solutionchallenge.fragment.RecommendListFragment

import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val PERbutton: Button = findViewById(R.id.ToPERlistButton)
        val TodayButton: Button = findViewById(R.id.ToTodayERButton)

        PERbutton.setOnClickListener {
            val fragment = RecommendListFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null) // 백 스택에 추가
                .commit()
        }

        TodayButton.setOnClickListener {
            val randomExercise = getRandomExercise()
            val dialog = RecommendationOfTodayDialog(this, randomExercise)
            dialog.show()
        }

    }


    private fun getRandomExercise(): Exercise {
        val randomIndex = Random.nextInt(exerciseList.size)
        return exerciseList[randomIndex]
    }

}