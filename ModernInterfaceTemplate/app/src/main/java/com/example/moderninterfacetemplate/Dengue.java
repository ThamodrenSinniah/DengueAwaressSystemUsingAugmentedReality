package com.example.moderninterfacetemplate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class Dengue extends AppCompatActivity {
    private CardView aedes;
    private CardView virus;
    private CardView malaysia;
    private CardView causes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dengue);


        //Show Aedes Mosquitoes
        aedes = (CardView) findViewById(R.id.aedes);
        aedes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMosquio();
            }
        });

        //Show Dengue Virus
        virus = (CardView) findViewById(R.id.virus);
        virus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showVirus();
            }
        });

        //Show Cases in Malaysia
        malaysia = (CardView) findViewById(R.id.malaysia);
        malaysia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMalaysia();
            }
        });

        //Show Causes of Dengue
        causes = (CardView) findViewById(R.id.causes);
        causes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCauses();
            }
        });


    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    //Show Aedes Mosquitoes
    public void showMosquio(){
        AlertDialog.Builder show = new AlertDialog.Builder(Dengue.this);
        show.setTitle("Aedes Mosquito");
        show.setMessage("Learn about the Dengue Virus vector, The Aedes Mosquito");

        LayoutInflater inflater = this.getLayoutInflater();
        View aedes = inflater.inflate(R.layout.aedes,null);

        show.setView(aedes);
        show.show();
    }

    //Show Dengue Virus
    public void showVirus(){
        AlertDialog.Builder show = new AlertDialog.Builder(Dengue.this);
        show.setTitle("Dengue Virus");
        show.setMessage("Learn about the Dengue Virus, the virus responsible for causing dengue fever");

        LayoutInflater inflater = this.getLayoutInflater();
        View denguevirus = inflater.inflate(R.layout.denguevirus,null);

        show.setView(denguevirus);
        show.show();
    }

    //Show Cases in Malaysia
    public void showMalaysia(){
        AlertDialog.Builder show = new AlertDialog.Builder(Dengue.this);
        show.setTitle("Cases in Malaysia");
        show.setMessage("Learn about the total amount of dengue cases in Malaysia throughout the years");

        LayoutInflater inflater = this.getLayoutInflater();
        View malaysia = inflater.inflate(R.layout.malaysia,null);

        show.setView(malaysia);
        show.show();
    }

    //Show Causes of Dengue
    public void showCauses(){
        AlertDialog.Builder show = new AlertDialog.Builder(Dengue.this);
        show.setTitle("Causes of Dengue Fever");
        show.setMessage("Learn what causes Dengue Fever to spread");

        LayoutInflater inflater = this.getLayoutInflater();
        View causes = inflater.inflate(R.layout.causes,null);

        show.setView(causes);
        show.show();
    }

}