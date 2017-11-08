package com.example.user.partyapplication;

/**
 * Created by User on 08-11-2017.
 */
import android.app.Application;
import android.util.Log;

public class UpdaterApplication extends Application
{
    private UpdatableActivity currentActivity = null;
    public static Game game = new Game();

    public synchronized Game getGame(){
        return game;
    }
    public synchronized void setUpdatable(UpdatableActivity updatable) {
        this.currentActivity = updatable;
        //Log.d("TAG3", currentActivity.string);
    }

    public synchronized UpdatableActivity getUpdatable(){
        return currentActivity;
    }
    private synchronized void updateCurrentActivity() {
        if (currentActivity != null)
            currentActivity.updateActivityFromBgThread();
    }

    private void loadDataFromServer() {
        // ...
        // load data from server
        // ...

        updateCurrentActivity();
    }

    public void onCreate() {
        super.onCreate();

        Log.d("Tag2", "Application");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                loadDataFromServer();
            }});
        thread.start();
    }
}