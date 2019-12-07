package com.example.cs441_project7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizMainMenu extends AppCompatActivity {

    private Button startButton;
    private Button secondButton;
    private Button thirdButton;
    int score1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main_menu);

        score1 = getIntent().getIntExtra("SCORE", 0);

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        findViewById(R.id.instruction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

    }

    public void openActivity() {
        Intent intent = new Intent (this, Main2Activity.class);
        startActivity(intent);
    }


    public void openActivity2() {
        Intent intent = new Intent (this, Instructions.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent (this, MainMenu.class);
        intent.putExtra("SCORE", score1);
        startActivity(intent);
    }

}