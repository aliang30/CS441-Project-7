package com.example.cs441_project6;

//Pick your car screen

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Button play1;
    private Button play2;
    private Button play3;
    private Button play4;
    private Button play5;
    private Button play6;
    private Button play7;
    private Button play8;
    private Button mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        play1 = (Button) findViewById(R.id.button0);
        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        play2 = (Button) findViewById(R.id.button);
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });

        play3 = (Button) findViewById(R.id.button1);
        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        play4 = (Button) findViewById(R.id.button2);
        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        play5 = (Button) findViewById(R.id.button3);
        play5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });

        play6 = (Button) findViewById(R.id.button4);
        play6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity5();
            }
        });

        play7 = (Button) findViewById(R.id.button5);
        play7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity6();
            }
        });

        play8 = (Button) findViewById(R.id.button6);
        play8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity7();
            }
        });

        mainMenu = (Button) findViewById(R.id.button7);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity8();
            }
        });

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
        Intent intent = new Intent (this, RedCar.class);
        startActivity(intent);
    }

    //Opens game screen
    public void openActivity1() {
        Intent intent = new Intent (this, BlackCar.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent (this, Ambulance.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent (this, Truck2.class);
        startActivity(intent);
    }

    public void openActivity4() {
        Intent intent = new Intent (this, OrangeCar.class);
        startActivity(intent);
    }

    public void openActivity5() {
        Intent intent = new Intent (this, Police.class);
        startActivity(intent);
    }

    public void openActivity6() {
        Intent intent = new Intent (this, Taxi.class);
        startActivity(intent);
    }

    public void openActivity7() {
        Intent intent = new Intent (this, Van.class);
        startActivity(intent);
    }

    //Opens main menu
    public void openActivity8() {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}

