package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton, button1, button2, button3, button4;
    ArrayList<Integer> answer = new ArrayList<Integer>();// creating array list no keep  answers
    TextView sumTextView, answerText, scoreText;
    int locationOfCorrectAnswer;
    int score = 0;
    int numbersOfQuestions = 0;



    public void chooseAnswer(View view) {

        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString()))// Comparing two strings correct answer and
        // button value , .equals is used in order to compare two strings
        {
            score = score + 1;
            answerText.setText("Attagirl!");


//         Log.i(" Correct"," You got it");
        } else {
            answerText.setText("Calculate one more Time bro");
//         Log.i(" Calculate one more", " Time bro");
        }
        numbersOfQuestions++;
        scoreText.setText((Integer.toString(score)) + "/" + Integer.toString(numbersOfQuestions));
        resetOnClick(); //reset question When question is answered it's calling
        // resetOnClick() and

    }

    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);// Setting visibility of the  Go button
    }

    public void resetOnClick() {



        Random random = new Random(); //Introducing random number


        int a = random.nextInt(21); // Range of random numbers
        int b = random.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = random.nextInt(4); // is setting random number for each choice button

        answer.clear();// will clear all data from array

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer)
                answer.add(a + b);// Adding answers to array

            else {
                int wrongAnswer = random.nextInt(21);// Setting random value for wrong answers
                while (wrongAnswer == a + b) {
                    wrongAnswer = random.nextInt(21); // Setting random value for wrong answers
                }
                answer.add(wrongAnswer);

            }
        }
        button1.setText(Integer.toString(answer.get(0)));// Passing random numbers to the button
        button2.setText(Integer.toString(answer.get(1)));// Passing random numbers to the button
        button3.setText(Integer.toString(answer.get(2)));// Passing random numbers to the button
        button4.setText(Integer.toString(answer.get(3)));// Passing random numbers to the button


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = findViewById(R.id.goButton); //initializing button here
        sumTextView = findViewById(R.id.sumTextView);
        answerText = findViewById(R.id.gameOverTextView);
        scoreText = findViewById(R.id.scoreTextView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);


        resetOnClick();
//        Random random = new Random(); //Introducing random number
//
//
//        int a = random.nextInt(21); // Range of random numbers
//        int b = random.nextInt(21);
//
//        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
//
//         locationOfCorrectAnswer = random.nextInt(4); // is setting random number for each choice button
//
//        for (int i = 0; i < 4; i++) {
//            if (i == locationOfCorrectAnswer)
//                answer.add(a + b);// Adding answers to array
//
//            else {
//                int wrongAnswer = random.nextInt(21);// Setting random value for wrong answers
//                while (wrongAnswer == a + b) {
//                    wrongAnswer = random.nextInt(21); // Setting random value for wrong answers
//                }
//                answer.add(wrongAnswer);
//
//            }
//        }
//        button1.setText(Integer.toString(answer.get(0)));// Passing random numbers to the button
//        button2.setText(Integer.toString(answer.get(1)));// Passing random numbers to the button
//        button3.setText(Integer.toString(answer.get(2)));// Passing random numbers to the button
//        button4.setText(Integer.toString(answer.get(3)));// Passing random numbers to the button




    }


}


