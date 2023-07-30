package com.example.work;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button by its ID
        Button button = findViewById(R.id.button);

        //OnClickListener for the button
        button.setOnClickListener(v -> {
            // AlertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Alert")
                    .setMessage("Select One Category to Use")
                    .setPositiveButton("OK", null)
                    .show();
        });

        // CardViews for the categories
        CardView geographyCard = findViewById(R.id.geographyCard);
        CardView entertainmentCard = findViewById(R.id.entertainmentCard);
        CardView scienceCard = findViewById(R.id.scienceCard);
        CardView generalKnowledgeCard = findViewById(R.id.generalKnowledgeCard);

        //  click listeners for each category CardView
        geographyCard.setOnClickListener(v -> openSecondActivity("Geography"));
        entertainmentCard.setOnClickListener(v -> openSecondActivity("Entertainment"));
        scienceCard.setOnClickListener(v -> openSecondActivity("Science"));
        generalKnowledgeCard.setOnClickListener(v -> openSecondActivity("General Knowledge"));
    }

    private void openSecondActivity(String category) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
