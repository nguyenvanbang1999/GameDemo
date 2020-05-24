package com.example.gamedemo;

import android.graphics.Point;

public interface FreeFall extends Move {
    final static double GRAVITY=0.001;
    default void setLocation(StateOfMotion stateOfMotionOfEntity){
        long currenTime=System.currentTimeMillis();
        if(Game.playerFinish){

            int t= (int) (currenTime-stateOfMotionOfEntity.time_preUpdate);

            int y0=stateOfMotionOfEntity.location.y;
            double v0=stateOfMotionOfEntity.y_speed;
            double g=FreeFall.GRAVITY;

            int y_next= (int) (y0+(g*t*t)/2 +v0*t);
            double v=  v0+g*t;

            stateOfMotionOfEntity.location.y=y_next;
            stateOfMotionOfEntity.y_speed=v;

        }
        stateOfMotionOfEntity.updateMotion(currenTime);

    }
}
