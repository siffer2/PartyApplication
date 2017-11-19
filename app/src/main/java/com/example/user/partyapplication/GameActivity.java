package com.example.user.partyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

//Return to MainMenuActivity, load fragments
public class GameActivity extends UpdatableActivity {

    CheckOrientation sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        sensor = new CheckOrientation(this.getApplicationContext());
        this.string = "Game!";
        //testMethod();
    }

    public void testMethod(){
        while(true){
            //Log.d("bammelam", "While loop startet");
            //Boolean testCase = sensor.isLeft();
            //Log.d("bammelam",String.valueOf(testCase));
            if (sensor.isLeft()) {
                Log.d("bammelam", "Phone orientation is left");
                break;
            }
        }
    }

    public void nextGame(View view){
        Log.d("aktivitet", "NY AKTIVITET!!!");
        nextActivity();
        finish();
    }

    @Override
    public void updateActivity() {

    }
}