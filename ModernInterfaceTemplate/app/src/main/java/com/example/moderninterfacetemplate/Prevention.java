package com.example.moderninterfacetemplate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class Prevention extends AppCompatActivity {

    private CardView breeding;
    private CardView bite;
    private CardView council;
    private CardView repellent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevention);

        //Breeding Prevention
        breeding = (CardView) findViewById(R.id.breeding);
        breeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBreeding();
            }
        });


        //Bite Prevention
        bite = (CardView) findViewById(R.id.bite);
        bite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBite();
            }
        });

     //Council Prevention
        council = (CardView) findViewById(R.id.towncouncil);
        council.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCouncil();
            }
        });


        //Repellent Prevention
        repellent = (CardView) findViewById(R.id.repellent);
        repellent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRepellent();
            }
        });


    }


    //Breeding Prevention
    public void openBreeding(){
        AlertDialog.Builder show = new AlertDialog.Builder(Prevention.this);
        show.setTitle("Breeding Prevention");
        show.setMessage("Learn how to prevent Aedes Mosquito from breeding");

        LayoutInflater inflater = this.getLayoutInflater();
        View breeding = inflater.inflate(R.layout.mosquitobreeding,null);

        show.setView(breeding);
        show.show();
    }

    //Bite Prevention
    public void openBite(){
        AlertDialog.Builder show = new AlertDialog.Builder(Prevention.this);
        show.setTitle("Mosquito Bite Prevention");
        show.setMessage("Learn how to prevent getting bitten by a Aedes Mosquito");

        LayoutInflater inflater = this.getLayoutInflater();
        View bite = inflater.inflate(R.layout.bite,null);

        show.setView(bite);
        show.show();
    }

    //Council Prevention
    public void openCouncil(){
        AlertDialog.Builder show = new AlertDialog.Builder(Prevention.this);
        show.setTitle("Calling the Town Council");
        show.setMessage("Aedes Mosquitoes getting out of hand? Here is what you should do");

        LayoutInflater inflater = this.getLayoutInflater();
        View council = inflater.inflate(R.layout.council,null);

        show.setView(council);
        show.show();
    }

    //Repellent Prevention
    public void openRepellent(){
        AlertDialog.Builder show = new AlertDialog.Builder(Prevention.this);
        show.setTitle("Repelling Mosquitoes");
        show.setMessage("Learns ways to repel mosquitoes by using tools and natural ingredients");

        LayoutInflater inflater = this.getLayoutInflater();
        View repel = inflater.inflate(R.layout.repellent,null);

        show.setView(repel);
        show.show();
    }




}