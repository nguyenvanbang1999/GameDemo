package com.example.gamedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameSurfaceView gameSurfaceView=new GameSurfaceView(this);
        setContentView(gameSurfaceView);



        Thread run=new Thread(){
            @Override
            public void run(){
                while (Game.gameRun){
                    if (!Game.checkCollision()){
                        Game.spawnStone();
                        Game.update();
                        gameSurfaceView.draw();
                    }
                    else{
                        gameSurfaceView.draw();
                        gameSurfaceView.drawEndGame();
                        Game.gameRun=false;
                    }
                }
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(MainActivity.this,EndActivity.class);
                startActivity(intent);
                finish();


            }
        };





        View decorView = getWindow().getDecorView();

        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }



        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        Game.height_screen=height;
        Game.width_screen=width;
        Entity.setEntitySize();


        Resources resources = getApplicationContext().getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
             Game.navigation_height=resources.getDimensionPixelSize(resourceId);
        }



        Game.setUp();
        gameSurfaceView.scaleIMG();

        run.start();
    }

}
