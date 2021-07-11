package com.example.pjt105

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.pjt105.databinding.RecyclerItemBinding

class QuestionAdapter : Adapter<QuestionAdapter.QuestionViewHolder>() {
    private val questions = mutableListOf<Question>()




    inner class QuestionViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bindItem(question: Question){
//                binding.
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questions[position]
        holder.bindItem(question)
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}