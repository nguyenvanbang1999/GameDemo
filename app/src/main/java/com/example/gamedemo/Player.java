package com.example.gamedemo;

public class Player extends Entity implements PlayerMove {
    static int status=0;


    public Player() {
        super(Game.width_screen/2-Entity.entitySize/2,Game.height_screen/5 * 4 ,0,0, Entity.entitySize/2);
    }
}
