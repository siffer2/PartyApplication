package com.example.user.partyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GameDrawingActivity extends UpdatableActivity {

    private  DrawingView drawingView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_drawing);
        //drawingView = (DrawingView) findViewById(R.id.DrawingView);

        final Button button = (Button) findViewById(R.id.button_id);

    }
    public void nextGame(View view){
        Log.d("aktivitet", "NY AKTIVITET!!!");
        nextActivity();
        //finish();
    }
}
