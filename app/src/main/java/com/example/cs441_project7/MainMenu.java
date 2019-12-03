package com.example.cs441_project6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button startButton;
    private Button secondButton;

    int score1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        score1 = getIntent().getIntExtra("SCORE", 0);

        /*
        startButton = (Button) findViewById(R.id.button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        secondButton = (Button) findViewById(R.id.button2);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        */

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
        Intent intent = new Intent (this, HighScore.class);
        intent.putExtra("SCORE", score1);
        startActivity(intent);
    }
}
