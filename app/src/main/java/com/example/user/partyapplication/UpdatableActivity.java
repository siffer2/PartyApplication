package com.example.user.partyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;

public abstract class UpdatableActivity extends AppCompatActivity {

    protected static Activity thisActivity;
    //Used to ensure no duplicate activities
    String activityType;
    protected static ArrayList<String> passedActivityTypes = new ArrayList<String>();

    protected static Game game = new Game();

    public UpdatableActivity(){
    }

    public Activity getThisActivity() {
        return thisActivity;
    }

    public void setThisActivity(Activity thisActivity) {
        this.thisActivity = thisActivity;
    }

    public void loadActivity(Activity currentActivity, Class NextActivity){
        Intent intent = new Intent(currentActivity, NextActivity);
        startActivity(intent);
    }

    public void nextActivity(){
        this.setThisActivity(this);
        Class NextActivity = game.nextActivity();
        if(NextActivity!=null){
            loadActivity(getThisActivity(), NextActivity);
        }
        else{
            loadActivity(getThisActivity(), MainMenuActivity.class);
        }
    }


    protected void isDuplicateActivity(String type){
        activityType = type;

        for (int i=0; i<passedActivityTypes.size();i++){
            if (activityType.equals(passedActivityTypes.get(i))){
                nextActivity();
            }
        }
        passedActivityTypes.add(type);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("aktivitet", "Aktiviteter:"+game.activities.toString());
        Log.d("aktivitet", "Aktiviteter:"+game.passedActivities.toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}