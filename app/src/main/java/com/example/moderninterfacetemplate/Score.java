package com.example.moderninterfacetemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Score extends AppCompatActivity {

    EditText name;
    Button submit;
    DatabaseReference reff;
    Names names;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        name=(EditText)findViewById(R.id.editName);
        submit=(Button)findViewById(R.id.submit);



        names= new Names();
        reff = FirebaseDatabase.getInstance().getReference().child("Names");

        Intent intent = getIntent();
        String scr = intent.getStringExtra("message");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringCheck = name.getText().toString().trim();
                if (TextUtils.isEmpty(stringCheck)) {
                    Toast.makeText(Score.this, "Please Enter Your Name Before Leaving", Toast.LENGTH_LONG).show();
                }else{
                    names.setName(name.getText().toString().trim());
                    names.setScore(scr);
                    reff.child("Scores").push().setValue(names);
                    Toast.makeText(Score.this, "Thank You " + name.getText().toString(), Toast.LENGTH_LONG).show();


                    back();
                }
            }
        });

    }

    public void back(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}