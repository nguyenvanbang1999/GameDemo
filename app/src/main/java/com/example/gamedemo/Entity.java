package com.example.gamedemo;

import android.graphics.Point;

public abstract class Entity implements Move {

    static int entitySize;

    public StateOfMotion stateOfMotion;
    public int radius;
    public void move(){
        setLocation(stateOfMotion);
    }

    public Entity(int x,int y,int x_speed,int y_speed, int radius) {
        this.stateOfMotion=new StateOfMotion(x,y,x_speed,y_speed);
        this.radius = radius;
    }

    public static void setEntitySize(){
        entitySize=Game.width_screen/15;
    }

}
