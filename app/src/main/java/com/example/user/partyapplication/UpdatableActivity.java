package com.example.user.partyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public abstract class UpdatableActivity extends AppCompatActivity {

    String string = new String("Hello");
    UpdaterApplication app;
    //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    //protected static Activity thisActivity;
    //protected static Game game = new Game();

    public UpdatableActivity(){
    }

    //Denne funktion skal returnere currentActivity fra UpdaterApplication.
    public Activity getThisActivity() {
        return app.getUpdatable();
    }
    /*
    public void setThisActivity(Activity thisActivity) {
        this.thisActivity = thisActivity;
    }
    */
    public void loadActivity(Activity currentActivity, Class NextActivity){
        Intent intent = new Intent(currentActivity, NextActivity);
        startActivity(intent);
    }

    public void nextActivity(){
        //this.setThisActivity(this);
        Class NextActivity = app.getGame().nextActivity();
        if(NextActivity!=null){
            Log.d("bammelam","Næste aktivitet indlæses");
            loadActivity(getThisActivity(), NextActivity);
        }
        else{
            Log.d("bammelam","Returnerer til menuen");
            loadActivity(getThisActivity(), MainMenuActivity.class);
        }
    }

    //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    public final void updateActivityFromBgThread() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updateActivity();
            }});
    }

    public abstract void updateActivity();

    @Override
    protected void onStart() {
        super.onStart();
        app = (UpdaterApplication)getApplication();
        app.setUpdatable(this);
    }

    @Override
    protected void onStop() {
        app = (UpdaterApplication)getApplication();
        app.setUpdatable(null);
        super.onStop();
    }
}