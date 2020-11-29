package com.example.moderninterfacetemplate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private CardView dengue;
    private CardView symptoms;
    private  CardView quiz;
    private  CardView ar;
    private CardView council;
    private CardView prevention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Open What is Dengue
        dengue = (CardView) findViewById(R.id.dengue);
        dengue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDengue();
            }
        });

        //Open Symptoms
        symptoms = (CardView) findViewById(R.id.symptoms);
        symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSymptoms();
            }
        });

        //Open Quiz
        quiz = (CardView) findViewById(R.id.quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuizDialog();
            }
        });

        //Open Augmented Reality
        ar = (CardView) findViewById(R.id.ar);
        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAR();
            }
        });

        //Open Town Council
        council = (CardView) findViewById(R.id.council);
        council.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTownCouncil();
            }
        });

        //Open Prevention
        prevention = (CardView) findViewById(R.id.prevention);
        prevention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openPrevention();
            }
        });

    }
    /*-------------------------------------------------------------------------------------------------------*/

    //FUNCTIONS FOR MAIN MENU

    //Open What is Dengue
    public void openDengue(){
        Intent intent = new Intent(this, Dengue.class);
        startActivity(intent);
    }

    //Open Symptoms
    public void openSymptoms(){
        Intent intent = new Intent(this, Symptoms.class);
        startActivity(intent);
    }

    //Open Prevention
    public void openPrevention(){
        Intent intent = new Intent(this,Prevention.class);
        startActivity(intent);
    }

    //Open Council
    public void openTownCouncil(){
        CouncilDialog councilDialog = new CouncilDialog();
        councilDialog.show(getSupportFragmentManager(),"EXAMPLE DIALOG");
    }

    //Open Quiz
    public void openQuizDialog(){
        QuizDialog quizDialog = new QuizDialog();
        quizDialog.show(getSupportFragmentManager(),"EXAMPLE DIALOG");
    }

    //Open Augmented Reality
    public void openAR(){
        Intent intent = new Intent(this,AugmentedList.class);
        startActivity(intent);
    }

}