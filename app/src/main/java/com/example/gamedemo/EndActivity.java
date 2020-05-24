package com.example.gamedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.SQLOutput;

public class EndActivity extends AppCompatActivity {
    private Button replayButton;
    private Button exitButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout parentView = new RelativeLayout(this);
        setContentView(parentView);


        replayButton=new Button(this);
        exitButton=new Button(this);
        textView=new TextView(this);

        textView.setText("Bạn quá ngu khi chơi cái game củ lìn này mà chỉ được có "+Game.score+" điểm ÓC CHÓ!");
        textView.setTextSize(50);

        replayButton.setText("Replay");
        exitButton.setText("Exit");


        replayButton.setY(Game.height_screen/2);
        replayButton.setX(Game.width_screen/5);
        exitButton.setY(Game.height_screen/2);
        exitButton.setX(Game.width_screen/2);

        parentView.addView(textView);
        parentView.addView(replayButton);
        parentView.addView(exitButton);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("replay");
                Intent intent=new Intent(EndActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("exit");
                finish();
                System.exit(0);

            }
        });



    }
}
