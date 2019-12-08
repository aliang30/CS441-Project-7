package com.example.cs441_project7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    private TextView countLabel;
    private TextView questionLabel;
    private ImageView questionImage;

    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    static final private int QUIZ_COUNT = 3;
    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;

    ArrayList<ArrayList <String>> quizArray = new ArrayList<>();

    String quizData[][] ={
            {"honda", "2018 Honda Civic Sedan" , "2020 Hyundai Elantra" , "2020 Honda Insight" , "2019 Honda Clarity Electric"},
            {"porsche", "Porsche" , "Lamborghini" , "Ferrari" , "Bentley"},
            {"dodge", "2019 Dodge Charger" , "2019 Dodge Journey" , "2020 Dodge Durango" , "2019 Dodge Grand Caravan"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        countLabel = (TextView)findViewById(R.id.countLabel);
        questionImage = findViewById(R.id.questionImage);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);

        //Create quizArray from quizData
        for (int i = 0; i < quizData.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<> ();

            tmpArray.add(quizData[i][0]); //Image
            tmpArray.add(quizData[i][1]); //Choice1
            tmpArray.add(quizData[i][2]); //Choice2
            tmpArray.add(quizData[i][3]); //Choice3
            tmpArray.add(quizData[i][4]); //Choice4

            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {
        countLabel.setText("Question " + quizCount);

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);

        questionImage.setImageResource(
                getResources().getIdentifier(quiz.get(0), "drawable" , getPackageName()));

        rightAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        quizArray.remove(randomNum);
    }

    public void checkAnswer(View view) {
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)) {
            alertTitle = "Good Job!";
            rightAnswerCount ++;
        } else {
            alertTitle = "Incorrect. Try again.";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                    Intent intent = new Intent(getApplicationContext(), QuizResult.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT" , rightAnswerCount);
                    startActivity(intent);
                }
                else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}
