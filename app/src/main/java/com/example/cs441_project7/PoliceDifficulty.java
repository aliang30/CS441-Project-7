package com.example.cs441_project7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PoliceDifficulty extends AppCompatActivity {


    private Button easyButton;
    private Button hardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_difficulty);

        easyButton = (Button) findViewById(R.id.button);
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });


        hardButton = (Button) findViewById(R.id.button2);
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

    }

    public void openActivity() {
        Intent intent = new Intent (this, Police.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent (this, PoliceHard.class);
        startActivity(intent);
    }
}
