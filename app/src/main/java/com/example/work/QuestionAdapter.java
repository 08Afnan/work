package com.example.work;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private ArrayList<TriviaQuestion> triviaQuestions;

    public QuestionAdapter(ArrayList<TriviaQuestion> triviaQuestions) {
        this.triviaQuestions = triviaQuestions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        TriviaQuestion question = triviaQuestions.get(position);
        holder.bind(question);
    }

    @Override
    public int getItemCount() {
        return triviaQuestions.size();
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder {
        private TextView questionTextView;
        private RadioGroup optionsRadioGroup;

        QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            optionsRadioGroup = itemView.findViewById(R.id.optionsRadioGroup);
        }

        void bind(TriviaQuestion question) {
            questionTextView.setText(question.getQuestion());

            optionsRadioGroup.removeAllViews(); // Clear previous options

            // Add options RadioButtons programmatically
            for (String option : question.getOptions()) {
                RadioButton radioButton = new RadioButton(itemView.getContext());
                radioButton.setText(option);
                optionsRadioGroup.addView(radioButton);
            }
        }
    }
}
