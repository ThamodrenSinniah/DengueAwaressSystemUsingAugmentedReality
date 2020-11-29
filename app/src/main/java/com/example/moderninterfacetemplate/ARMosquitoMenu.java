package com.example.moderninterfacetemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ARMosquitoMenu extends AppCompatActivity {

    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_r_mosquito_menu);

        nextButton=(Button)findViewById(R.id.viewARmosquito);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openARMosquito();
            }
        });


    }


    public void openARMosquito(){
        Intent intent = new Intent(this, AugmentedMosquito.class);
        startActivity(intent);

    }
}