package com.example.work;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;


import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private ArrayList<TriviaQuestion> triviaQuestionList;


    public QuestionAdapter(ArrayList<TriviaQuestion> triviaQuestionList) {
        this.triviaQuestionList = triviaQuestionList;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        TriviaQuestion triviaQuestion = triviaQuestionList.get(position);
        holder.bind(triviaQuestion);
    }

    @Override
    public int getItemCount() {
        return triviaQuestionList.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textViewQuestion;
        private TriviaQuestion triviaQuestion;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewQuestion = itemView.findViewById(R.id.textViewQuestion);
            itemView.setOnClickListener(this);
        }

        public void bind(TriviaQuestion triviaQuestion) {
            this.triviaQuestion = triviaQuestion;
            textViewQuestion.setText(triviaQuestion.getQuestion());
        }

        @Override
        public void onClick(View v) {

        }

    // Custom interface to handle click events

}}

