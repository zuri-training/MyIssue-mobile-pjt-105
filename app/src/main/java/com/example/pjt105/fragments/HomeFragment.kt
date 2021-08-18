package com.example.pjt105.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pjt105.DummyData
import com.example.pjt105.Question
import com.example.pjt105.QuestionAdapter
import com.example.pjt105.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: QuestionAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root



        makeAPost()

        return view

    }




    private fun makeAPost(){
        val adapter = QuestionAdapter()
        val recyclerView = binding.QuestionRv

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        adapter.setupQuestions(DummyData.questions)

        //initializing views from the frament_home layout
        val qText = binding.postEt.text
        val qTag = binding.tagEt.text
        val postEditTextCv = binding.postEditTextCv


        binding.postCv.setOnClickListener {
            postEditTextCv.visibility = View.VISIBLE
        }

        binding.postButton.setOnClickListener {
            val question = Question(qText.toString(), qTag.toString())
            val questions = mutableListOf(question)
            adapter.setupQuestions(questions)
            Toast.makeText(activity, "Posted", Toast.LENGTH_SHORT).show()

            postEditTextCv.visibility = View.GONE

        }

    }


}


