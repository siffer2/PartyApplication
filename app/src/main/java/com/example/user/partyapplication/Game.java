package com.example.user.partyapplication;

import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by User on 08-11-2017.
 */

public class Game extends AppCompatActivity {
    Queue activities = new <QuizActivity>LinkedList();
    Stack passedActivities = new <QuizActivity>Stack();
    int gameState = 0;

    public Game(){
    }

    //Starts the game
    public boolean BeginGame(){
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

    //Manually filling activities in, for demonstrative purposes.
    public void generateActivities(){
        activities.add(new DrawingActivity());
        activities.add(new CardActivity());
        activities.add(new CardActivity());
        activities.add(new CardActivity());
        activities.add(new QuizActivity());
        activities.add(new QuizActivity());
        activities.add(new QuizActivity());
        activities.add(new QuizActivity());


    }

    public boolean activitiesLeft(){
        return !activities.isEmpty();
    }

    //Ends the game, makes sure everything is reset, makes sure the user is returned to the main menu
    public void endGame(){
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
            Class nextActivity = activities.peek().getClass();
            passedActivities.push(activities.remove());
            return nextActivity;
        }
        else{
            endGame();
            return null;
        }
    }

    public int getGameState(){return this.gameState;}
    public boolean setGameState(int gameState){this.gameState = gameState; return true;}
}
