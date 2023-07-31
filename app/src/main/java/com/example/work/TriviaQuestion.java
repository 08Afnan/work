package com.example.work;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class TriviaQuestion implements Parcelable {
    private String question;
    private String correctAnswer;
    private ArrayList<String> incorrectAnswers;
    private String selectedAnswer;

    // Add a getter and setter for the selected answer
    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public TriviaQuestion(String s, String optionA, String optionB, String optionC, String optionD, String optionA1) {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public ArrayList<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(ArrayList<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    // Add the getOptions method to return all options for the question
    public ArrayList<String> getOptions() {
        ArrayList<String> options = new ArrayList<>();
        options.add(correctAnswer);
        options.addAll(incorrectAnswers);
        return options;
    }

    public TriviaQuestion(String question, String correctAnswer, ArrayList<String> incorrectAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    // Parcelable implementation methods
    protected TriviaQuestion(Parcel in) {
        question = in.readString();
        correctAnswer = in.readString();
        incorrectAnswers = in.createStringArrayList();
    }

    public static final Creator<TriviaQuestion> CREATOR = new Creator<TriviaQuestion>() {
        @Override
        public TriviaQuestion createFromParcel(Parcel in) {
            return new TriviaQuestion(in);
        }

        @Override
        public TriviaQuestion[] newArray(int size) {
            return new TriviaQuestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(correctAnswer);
        dest.writeStringList(incorrectAnswers);
    }



}
