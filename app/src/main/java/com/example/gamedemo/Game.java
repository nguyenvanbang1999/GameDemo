package com.example.gamedemo;

import android.graphics.Point;
import android.view.Display;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public static ArrayList<Stone> stones;
    public static Player player;
    static int time_toSpawnNextStone;
    static long time_preStoneSpawn;
    static int score=0;


    public static int height_screen;
    public static int width_screen;
    public static int navigation_height;



    public static boolean gameRun;
    public static boolean playerFinish;
    public static Point backgroundLocation1;
    public static Point backgroundLocation2;


    public static boolean checkCollision(){
        int player_X=player.stateOfMotion.location.x;
        int player_Y=player.stateOfMotion.location.y;
        if (player.stateOfMotion.location.x<Entity.entitySize/2||player.stateOfMotion.location.x>Game.width_screen-Entity.entitySize/2){
            return true;
        }


        else for (Stone s:stones){
            int x=s.stateOfMotion.location.x;
            int y=s.stateOfMotion.location.y;
            int stone_Radius=s.radius;
            double distance=Math.sqrt((x-player_X)*(x-player_X)+(y-player_Y)*(y-player_Y));
            if (distance<=player.radius+stone_Radius){
                return true;
            }
        }

        return false;
    }

    public static void update(){
        for (int i=0;i<stones.size();i++){
            Stone s=stones.get(i);
            s.move();
            if (s.stateOfMotion.location.y>1870){
                score++;
                stones.remove(s);
            }
        }
        if (Game.playerFinish){
            backgroundLocation1.y++;
            backgroundLocation2.y++;
            if (backgroundLocation1.y>=Game.navigation_height+Game.height_screen){
                backgroundLocation1.y=-(Game.navigation_height+Game.height_screen);

            }
            if (backgroundLocation2.y>=Game.navigation_height+Game.height_screen){
                backgroundLocation2.y=-(Game.navigation_height+Game.height_screen);
            }
        }
        player.move();



    }

    public static void endGame(){
        gameRun=false;

    }
    public static void spawnStone(){
        if(Game.playerFinish){
            long current_time=System.currentTimeMillis();


            if (current_time>=time_preStoneSpawn+time_toSpawnNextStone){
                Random rd= new Random();
                int random_x=rd.nextInt(Game.width_screen);


                int random_radius=rd.nextInt(80);
                Stone1 stone1=new Stone1(random_x,-30);
                stones.add(stone1);
                time_preStoneSpawn=current_time;

                int rand_time=rd.nextInt(1500-Game.score*5);
                time_toSpawnNextStone=rand_time;
            }
        }
    }
    static void setUp(){
        player=new Player();
        gameRun=true;
        playerFinish=false;
        backgroundLocation1=new Point(0,0);
        stones=new ArrayList<>();
        backgroundLocation2=new Point(0,-(Game.height_screen+Game.navigation_height));
        time_toSpawnNextStone=0;
        time_preStoneSpawn=0;
        score=0;

    }





}
