package com.example.moderninterfacetemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        back = (Button)findViewById(R.id.btnReturn);





        TextView resultLabel=(TextView)findViewById(R.id.resultLabel);
        TextView totalScoreLabel = (TextView)findViewById(R.id.totalScoreLabel);

        int score=getIntent().getIntExtra("RIGHT_ANSWER_COUNT",0);

        SharedPreferences settings = getSharedPreferences("ModernInterfaceTemplate", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore",0);
        totalScore+=score;



        resultLabel.setText(score + " / 5");
        totalScoreLabel.setText("Total Score: " + totalScore);

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore",totalScore);
        editor.commit();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });





    }

    public void back(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}
