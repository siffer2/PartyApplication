package com.example.user.partyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameDrawingActivity extends UpdatableActivity {

    private  DrawingView drawingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_drawing);
        //drawingView = (DrawingView) findViewById(R.id.DrawingView);

    }

    @Override
    public void updateActivity() {

    }
}
