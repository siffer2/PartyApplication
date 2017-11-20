package com.example.user.partyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

//Return to MainMenuActivity, load fragments
public class GameActivity extends UpdatableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final TextView text = (TextView) findViewById(R.id.text_view_id);

        String[] quizValues = selectQuiz();
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);

        this.string = "Game!";
        QuizInput quizinput = new QuizInput(this);
    }

    public String[] selectQuiz(){
        int minQuiz = 1;
        int maxQuiz = 3;
        int quiz = ThreadLocalRandom.current().nextInt(minQuiz, maxQuiz + 1);
        String[] quizValues;
        if (quiz==1) {
            return quizValues = getResources().getStringArray(R.array.q1);
        }
        else if (quiz==2){
            return quizValues = getResources().getStringArray(R.array.q2);
        }
        else if (quiz==3){
            return quizValues = getResources().getStringArray(R.array.q3);
        }
        return null;
    }
    public void nextGame(View view){
        Log.d("aktivitet", "NY AKTIVITET!!!");
        nextActivity();
        //finish();
    }
}