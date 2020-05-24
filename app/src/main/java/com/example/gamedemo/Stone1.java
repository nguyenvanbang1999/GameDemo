package com.example.gamedemo;

import android.graphics.Point;

public  class Stone1 extends Stone implements FreeFall  {
    final static int RADIUS_STONE_1=Entity.entitySize/2;


    public Stone1(int x, int y) {
        super(x, y,0, 0, Stone1.RADIUS_STONE_1);
    }
}
