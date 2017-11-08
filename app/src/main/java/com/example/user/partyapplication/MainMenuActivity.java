package com.example.user.partyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainMenuActivity extends UpdatableActivity {

    //UpdaterApplication app = (UpdaterApplication)getApplication();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void startGame(View view){
        Log.d("bammelam","Spillet er startet");
        app.getGame().BeginGame();
        nextActivity();
        //finish();
    }

    @Override
    public void updateActivity() {

    }
}
