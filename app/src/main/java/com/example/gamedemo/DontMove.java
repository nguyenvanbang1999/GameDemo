package com.example.gamedemo;

import android.graphics.Point;

public interface DontMove extends Move {
    default void setLocation(Point locationOfEntity){

    }

}
