package com.example.cs441_project7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Truck2GameOver1 extends AppCompatActivity {


    private Button retry;
    private Button chooseCar;
    private Button mainMenu;
    int highScore1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck2_game_over1);

        TextView score = findViewById(R.id.score);
        TextView highScore = findViewById(R.id.high_score);

        int score1 = getIntent().getIntExtra("SCORE", 0);

        score.setTextColor(Color.WHITE);
        score.setText("Score : " + score1);

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        highScore1 = settings.getInt("HIGH_SCORE", 0);

        if (score1 > highScore1) {
            highScore.setTextColor(Color.BLUE);
            highScore.setText("New High Score: " + score1);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", score1);
            editor.commit();
        } else {
            highScore.setTextColor(Color.WHITE);
            highScore.setText("High Score : " + highScore1);
        }


        retry = (Button) findViewById(R.id.button);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        chooseCar = (Button) findViewById(R.id.button1);
        chooseCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });


        mainMenu = (Button) findViewById(R.id.button2);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        blinkingEffect();
    }


    private void blinkingEffect() {
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //1000 millisecond = 1 second
                int blinkTime = 1000;

                try{Thread.sleep(blinkTime);}
                catch (Exception e) {}

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Finds text and makes it disappear
                        TextView text = findViewById(R.id.text);

                        if(text.getVisibility() == View.VISIBLE){
                            text.setVisibility(View.INVISIBLE);
                        }
                        else{
                            //Makes text reappear
                            text.setVisibility(View.VISIBLE);
                        }
                        blinkingEffect();
                    }
                });
            }
        }).start();
    }


    //Opens game screen
    public void openActivity() {
        Intent intent = new Intent (this, Truck2.class);
        startActivity(intent);
    }

    //Opens choose car screen
    public void openActivity1() {
        Intent intent = new Intent (this, Main2Activity.class);
        startActivity(intent);
    }

    //Opens main menu
    public void openActivity2() {
        Intent intent = new Intent (this, MainMenu.class);
        intent.putExtra("SCORE", highScore1);
        startActivity(intent);
    }

}
