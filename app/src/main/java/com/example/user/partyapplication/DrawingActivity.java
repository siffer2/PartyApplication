package com.example.user.partyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DrawingActivity extends UpdatableActivity {

    private DrawingView drawingView;
    private TextView textView;
    private Button button;
    private Button button2;
    private int buttonPresses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_drawing);
        drawingView = (DrawingView) findViewById(R.id.drawingView);
        isDuplicateActivity("fundamental");
        button = (Button) findViewById(R.id.drawButton);
        button2 = (Button) findViewById(R.id.drawButton2);
        textView = (TextView)findViewById(R.id.drawText);


    }

    public void eraseDrawing (View view){
        drawingView.killsomething();

        //TODO
    }
    public void hideText(View view){
        if(buttonPresses==0) {
            textView.setVisibility(view.GONE);
            button2.setVisibility(view.VISIBLE);
            drawingView.setVisibility(view.VISIBLE);
            button.setText("Next game");
            buttonPresses++;
        }
        else {
            nextActivity();
            finish();
        }
    }
}
