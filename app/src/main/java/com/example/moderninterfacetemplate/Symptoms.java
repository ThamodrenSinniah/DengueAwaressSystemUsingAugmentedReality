package com.example.moderninterfacetemplate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class Symptoms extends AppCompatActivity {
    private CardView fever;
    private CardView rashes;
    private CardView headache;
    private CardView vomit;
    private CardView eyepain;
    private CardView jointpain;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        //Show Fever
        fever = (CardView) findViewById(R.id.fever);
        fever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFever();
            }
        });

        //Show Rashes
        rashes = (CardView) findViewById(R.id.rashes);
        rashes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRashes();
            }
        });

        //Show Headache
        headache = (CardView) findViewById(R.id.headache);
        headache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHeadache();
            }
        });

        //Show Vomit
        vomit = (CardView) findViewById(R.id.vomit);
        vomit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showVomit();
            }
        });

        //Show Eye Pain
        eyepain = (CardView) findViewById(R.id.eyepain);
        eyepain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEyepain();
            }
        });

        //Show Joint Pain
        jointpain = (CardView) findViewById(R.id.jointpain);
        jointpain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showJointpain();
            }
        });

        btn = (Button)findViewById(R.id.sympBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPrevention();
            }
        });


    }
/*------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //FUNCTIONS

    //Show Fever
    public void showFever(){
        AlertDialog.Builder show = new AlertDialog.Builder(Symptoms.this);
        show.setTitle("Fever");
        show.setMessage("Everything you need to know about Fever");

        LayoutInflater inflater = this.getLayoutInflater();
        View fever = inflater.inflate(R.layout.fever,null);

        show.setView(fever);
        show.show();
    }

    //Show Rashes
    public void showRashes(){
        AlertDialog.Builder show = new AlertDialog.Builder(Symptoms.this);
        show.setTitle("Rashes");
        show.setMessage("Everything you need to know about Rashes");

        LayoutInflater inflater = this.getLayoutInflater();
        View rashes = inflater.inflate(R.layout.rashes,null);

        show.setView(rashes);
        show.show();
    }

    //Show Headache
    public void showHeadache(){
        AlertDialog.Builder show = new AlertDialog.Builder(Symptoms.this);
        show.setTitle("Headache");
        show.setMessage("Everything you need to know about Headaches");

        LayoutInflater inflater = this.getLayoutInflater();
        View headache = inflater.inflate(R.layout.headache,null);

        show.setView(headache);
        show.show();
    }

    //Show Vomit
    public void showVomit(){
        AlertDialog.Builder show = new AlertDialog.Builder(Symptoms.this);
        show.setTitle("Vomit");
        show.setMessage("Everything you need to know about Vomiting and Nausea");

        LayoutInflater inflater = this.getLayoutInflater();
        View vomit = inflater.inflate(R.layout.vomit,null);

        show.setView(vomit);
        show.show();
    }

    //Show Eye Pain
    public void showEyepain(){
        AlertDialog.Builder show = new AlertDialog.Builder(Symptoms.this);
        show.setTitle("Eye Pain");
        show.setMessage("Everything you need to know about Eye Pain");

        LayoutInflater inflater = this.getLayoutInflater();
        View eyepain = inflater.inflate(R.layout.eyepain,null);

        show.setView(eyepain);
        show.show();
    }

    //Show Joint Pain
    public void showJointpain(){
        AlertDialog.Builder show = new AlertDialog.Builder(Symptoms.this);
        show.setTitle("Joint Pain");
        show.setMessage("Everything you need to know about Joint Pain");

        LayoutInflater inflater = this.getLayoutInflater();
        View jointpain = inflater.inflate(R.layout.jointpain,null);

        show.setView(jointpain);
        show.show();
    }


    public void openPrevention(){
        Intent intent = new Intent(this, Prevention.class);
        startActivity(intent);

    }


}