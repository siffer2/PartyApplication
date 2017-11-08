package com.example.user.partyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;

public abstract class UpdatableActivity extends AppCompatActivity {

    String string = new String("Hello");

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
        UpdaterApplication app = (UpdaterApplication)getApplication();
        app.setUpdatable(this);
    }

    @Override
    protected void onStop() {
        UpdaterApplication app = (UpdaterApplication)getApplication();
        app.setUpdatable(null);
        super.onStop();
    }
}