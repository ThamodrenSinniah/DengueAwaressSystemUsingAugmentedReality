package com.example.moderninterfacetemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AugmentedList extends AppCompatActivity {
    private CardView aedesMosquito;
    private CardView shooting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_augmented_list);

        //Aedes Mosquito
        aedesMosquito = (CardView) findViewById(R.id.dengue);
        aedesMosquito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMosquito();
            }
        });

        //Shooting
        shooting = (CardView) findViewById(R.id.game);
        shooting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGame();
            }
        });


    }

    //Open What is Dengue
    public void openMosquito(){
        Intent intent = new Intent(this, ARMosquitoMenu.class);
        startActivity(intent);

    }

    //Open Game
    public void openGame(){
       Intent intent = new Intent(this, AugmentedGame.class);
        startActivity(intent);

    }




}