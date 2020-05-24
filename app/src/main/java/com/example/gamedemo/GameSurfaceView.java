package com.example.gamedemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class GameSurfaceView extends SurfaceView  {
     Bitmap stone = BitmapFactory.decodeResource(getResources(), R.drawable.stone);
     Bitmap player = BitmapFactory.decodeResource(getResources(), R.drawable.player);
     Bitmap background=BitmapFactory.decodeResource(getResources(), R.drawable.background);
    Bitmap background1=BitmapFactory.decodeResource(getResources(), R.drawable.background1);
    Bitmap background2=BitmapFactory.decodeResource(getResources(), R.drawable.background2);


    public void draw(){
        SurfaceHolder holder=getHolder();
        Canvas canvas=holder.lockCanvas();

        if (canvas!=null) {

            canvas.drawColor(Color.WHITE);
            Paint paint = new Paint();
            canvas.drawBitmap(background,Game.backgroundLocation1.x,Game.backgroundLocation1.y,paint);
            canvas.drawBitmap(background,Game.backgroundLocation2.x,Game.backgroundLocation2.y,paint);
            if (!Game.playerFinish){
                paint.setColor(Color.WHITE);
                paint.setTextSize(Entity.entitySize*2);
                canvas.drawText("Tap to Play",Entity.entitySize*3,Entity.entitySize*10,paint);
            }
            for (Stone s:Game.stones){
                canvas.drawBitmap(stone, s.stateOfMotion.location.x-Entity.entitySize/2,
                        s.stateOfMotion.location.y-Entity.entitySize/2, paint);
            }
            canvas.drawBitmap(player,Game.player.stateOfMotion.location.x-Entity.entitySize/2,
                    Game.player.stateOfMotion.location.y-Entity.entitySize/2,paint);

            if(Game.gameRun){
                paint.setColor(Color.WHITE);
                paint.setTextSize(Entity.entitySize);
                canvas.drawText("SCORE: "+Game.score,5,Entity.entitySize,paint);
            }




            holder.unlockCanvasAndPost(canvas);
        }

    }


    public void drawEndGame(){
        SurfaceHolder holder=getHolder();
        Canvas canvas=holder.lockCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(Entity.entitySize*2);
        canvas.drawText("Game Over!",Entity.entitySize*2,Entity.entitySize*10,paint);
        canvas.drawText(Game.score+"",Entity.entitySize*6,Entity.entitySize*12,paint);
        holder.unlockCanvasAndPost(canvas);

    }

    public void scaleIMG(){
        stone=Bitmap.createScaledBitmap(stone,Entity.entitySize,Entity.entitySize,false);
        player=Bitmap.createScaledBitmap(player,Entity.entitySize,Entity.entitySize,false);
        background=Bitmap.createScaledBitmap(background,Game.width_screen,Game.height_screen+Game.navigation_height,false);
        background1=Bitmap.createScaledBitmap(background1,Game.width_screen,Game.height_screen+Game.navigation_height,false);
        background2=Bitmap.createScaledBitmap(background2,Game.width_screen,Game.height_screen+Game.navigation_height,false);

    }

    public GameSurfaceView(Context context) {
        super(context);
        this.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!Game.playerFinish){
                    Game.playerFinish=true;
                    Player.status=1;
                }
                if(Player.status==1){
                    Player.status=-1;
                }

                else if(Player.status==-1){
                    Player.status=1;
                }




            }
        });
    }


}
