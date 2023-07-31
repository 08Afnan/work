package com.example.work;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView; // Add this import statement

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HighScoreAdapter extends RecyclerView.Adapter<HighScoreAdapter.ViewHolder> {

    private List<HighScore> highScoresList;

    public HighScoreAdapter(List<HighScore> highScoresList) {
        this.highScoresList = highScoresList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_high_score, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HighScore highScore = highScoresList.get(position);
        holder.textViewPlayerName.setText(highScore.getPlayerName());
        holder.textViewScore.setText(String.valueOf(highScore.getScore()));
    }

    @Override
    public int getItemCount() {
        return highScoresList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewPlayerName;
        TextView textViewScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPlayerName = itemView.findViewById(R.id.textViewPlayerName);
            textViewScore = itemView.findViewById(R.id.textViewScore);
        }
    }
}
