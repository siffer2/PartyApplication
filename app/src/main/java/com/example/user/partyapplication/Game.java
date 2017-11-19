package com.example.user.partyapplication;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by User on 08-11-2017.
 */

public class Game extends AppCompatActivity {
    Queue activities = new <GameActivity>LinkedList();
    Stack passedActivities = new <GameActivity>Stack();
    int gameState = 0;
    //Activity currentGameActivity;

    public Game(){
    }

    //Starts the game
    public boolean BeginGame(){
        Log.d("bammelam","Gamestate er 1, der genereres aktiviteter");
        //Makes sure that no activities is in the queue or the stack when the game starts
        if(!activities.isEmpty()){
            activities.clear();
        }
        if(!passedActivities.isEmpty()){
            passedActivities.clear();
        }

        setGameState(1);
        generateActivities();
        return true;
    }

    //Fills out the activity queue
    public void generateActivities(){
        activities.add(new GameActivity());
        activities.add(new GameActivity());
        activities.add(new GameDrawingActivity());
        activities.add(new GameActivity());

    }

    //Updates gameState, should check wether the activity queu contains values or not
    public boolean activitiesLeft(){
        Log.d("bammelam",!activities.isEmpty()+"");
        return !activities.isEmpty();
    }

    //Ends the game, makes sure everything is reset, makes sure the user is returned to the main menu
    public void endGame(){
        Log.d("aktivitet", "SPILLET ER SLUT!!!!");
        setGameState(0);
        if(!activities.isEmpty()){
            activities.clear();
        }
        if(!passedActivities.isEmpty()){
            passedActivities.clear();
        }
    }

    public Class nextActivity(){
        if(activitiesLeft()){
            Log.d("bammelam","Der er flere aktiviteter tilbage!");
            Class nextActivity = activities.peek().getClass();
            passedActivities.push(activities.remove());
            return nextActivity;
        }
        else{
            Log.d("bammelam","Der er ikke flere aktiviteter tilbage");
            endGame();
            return null;
        }
    }

    public int getGameState(){return this.gameState;}
    public boolean setGameState(int gameState){this.gameState = gameState; return true;}
}
