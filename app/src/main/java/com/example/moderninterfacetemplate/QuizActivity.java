package com.example.moderninterfacetemplate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;
    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList <ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][]={
            //{Question , Right Answer, Choice1, Choice2, Choice3}
            {"What type of mosquito is responsible of infecting dengue?","Aedes","Anisoptera","Socmic","Diptera"},
            {"Which of these are NOT a symptom of Dengue","Hair Fall","Rashes","Fever","All of the listed"},
            {"How do you identify an Aedes Mosquito","It has white markings on the legs","It has no wings","It is active during the nighttime","They rest in hot and dry areas"},
            {"Which of the options below is a way to protect yourself from dengue?","All of the listed","Wear long-sleeve shirts and long pants","Get rid of stagnant water","Treat clothes with repellents"},
            {"How is dengue transmitted?","Transmitted by the bite of an Aedes mosquito infected with the virus","Transmitted if exposed to the virus in a infected object","Transmitted if exposed to radiation","Transmitted by the bite of a mosquito"},
            {"How many cases of Dengue Fever has been recorded in Malaysia?","More than 100,000","Less than 100,000","Less than 50,000","Malaysia has 0 recorded cases of Dengue Fever"},


    };
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"You cannot return to menu when answering quiz", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);

        //Create quizArray from quizData
        for (int i = 0; i < quizData.length; i++){

            //Prepare array
            ArrayList<String> tmpArray =  new ArrayList<>();
            tmpArray.add(quizData[i][0]);   //Question
            tmpArray.add(quizData[i][1]);   //RightAnswer
            tmpArray.add(quizData[i][2]);   //Choice1
            tmpArray.add(quizData[i][3]);   //Choice2
            tmpArray.add(quizData[i][4]);   //Choice3

            //Add tmpArray
            quizArray.add(tmpArray);
        }
        showNextQuiz();
    }

    public void showNextQuiz(){
        countLabel.setText("Q"+quizCount);

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());
        ArrayList<String> quiz = quizArray.get(randomNum);
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));


        quizArray.remove(randomNum);
    }

    public void checkAnswer(View view){

        //Button pressed
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)){
            alertTitle="Correct";
            rightAnswerCount++;

        }else{
            alertTitle="Wrong";
        }

        //Create Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : "+rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(quizCount == QUIZ_COUNT){
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT",rightAnswerCount);
                    startActivity(intent);
                }else{
                    quizCount++;
                    showNextQuiz();
                }

            }
        });
        builder.setCancelable(false);
        builder.show();

    }





}