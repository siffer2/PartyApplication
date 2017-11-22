package com.example.user.partyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public abstract class UpdatableActivity extends AppCompatActivity {

    public String string = new String("Hello");
    protected static Activity thisActivity;
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
            Log.d("bammelam","Næste aktivitet indlæses");
            loadActivity(getThisActivity(), NextActivity);
        }
        else{
            Log.d("bammelam","Returnerer til menuen");
            //loadActivity(getThisActivity(), MainMenuActivity.class);
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        //Log.d("aktivitet", "currentactivity er" + ((UpdaterApplication) getApplication()).getUpdatable());
        Log.d("aktivitet", "Aktiviteter:"+game.activities.toString());

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}