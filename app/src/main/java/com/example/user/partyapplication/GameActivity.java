package com.example.user.partyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

//Return to MainMenuActivity, load fragments
public class GameActivity extends UpdatableActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void nextGame(View view){
        Log.d("bammelam", "Så er vi i gang med spillet!");
        nextActivity();
        finish();
    }

    @Override
    public void updateActivity() {

    }
}