package com.example.gamedemo;

import android.graphics.Point;

public class StateOfMotion {
    public Point location;
    public double x_speed;
    public double y_speed;
    public long time_preUpdate;

    public StateOfMotion(int x, int y,double x_speed,double y_speed) {
        location=new Point(x,y);

        this.x_speed=x_speed;
        this.y_speed=y_speed;
        this.time_preUpdate=System.currentTimeMillis();
    }

    public void updateMotion(int x,int y,double x_speed,double y_speed){
        location.x=x;
        location.y=y;
        this.x_speed=x_speed;
        this.y_speed=y_speed;
        this.time_preUpdate=System.currentTimeMillis();
    }
    public void updateMotion(long time_preUpdate){
        this.time_preUpdate=time_preUpdate;
    }
}
