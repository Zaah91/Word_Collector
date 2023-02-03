package com.example.word_collector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.word_collector.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // binder til ActivityMain
    private val words = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.buttonSaveWord.setOnClickListener {
            //var editText = binding.edittextTextOutput
            var text = binding.edittextTextOutput.text.toString() .trim()

            if (text.isEmpty()){
                binding.edittextTextOutput.error = "Insert text"
                return@setOnClickListener
            }

            words.add(text)
            binding.edittextTextOutput.text.clear()
        }
        binding.buttonClearWords.setOnClickListener {

            words.clear()

        }
        binding.buttonShowWords.setOnClickListener {
            if (words.count() == 0){
                binding.textviewOutput.text = "No words"
            }

            var text = words.joinToString( separator = " ")
            binding.textviewOutput.text = text


        }
    }
}