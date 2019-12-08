package com.example.cs441_project7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        findViewById(R.id.menuButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        TextView totalScoreLabel = (TextView) findViewById(R.id.totalScoreLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT" ,0);

        SharedPreferences settings = getSharedPreferences("quizApp", Context.MODE_PRIVATE);

        int totalScore = settings.getInt("totalScore", 0);
        totalScore = totalScore + score;

        resultLabel.setText(score + " / 6");
        totalScoreLabel.setText("Total Score : " + totalScore);

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore" , totalScore);
        editor.commit();

    }

    public void openActivity() {
        Intent intent = new Intent (this, QuizMainMenu.class);
        startActivity(intent);
    }

}
