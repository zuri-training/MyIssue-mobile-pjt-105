package com.example.pjt105

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.pjt105.databinding.FragmentHomeBinding
import com.example.pjt105.databinding.RecyclerItemBinding

class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>(){
    private val questions = mutableListOf<Question>()

    fun setupQuestions(questions: List<Question>){
        this.questions.addAll(0, questions)
        notifyDataSetChanged()
    }



    inner class QuestionViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun bindingItem(question: Question){
                binding.cardViewTv4.text = question.QuestionText
                binding.cardViewTv3.text = question.tag
//                binding.cardViewTv2.text = question.timePosted
//                binding.CardViewTv5.text = question.numOfAnswers
//                binding.starIconIv.setImageResource(question.image)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder(RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            )
        )
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questions[position]
        holder.bindingItem(question)
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}