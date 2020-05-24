package com.example.gamedemo;

import android.graphics.Point;

public interface PlayerMove extends  Move {
    static final int PLAYER_SPEED=8;

    default void setLocation(StateOfMotion stateOfMotionOfEntity){
        if(Game.playerFinish){

            long currentTime=System.currentTimeMillis();
            long time=currentTime-stateOfMotionOfEntity.time_preUpdate;
            int x_next= stateOfMotionOfEntity.location.x+Player.PLAYER_SPEED*Player.status;
            stateOfMotionOfEntity.location.x=x_next;

            stateOfMotionOfEntity.updateMotion(currentTime);

        }
    }
}
