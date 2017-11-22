package com.example.user.partyapplication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

//Return to MainMenuActivity, load fragments
public class GameActivity extends UpdatableActivity {

    String[] quizValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Randomly selects one of implementet questions, and returns the values for the UI.
        quizValues = selectQuiz();

        //Textview for the question is first, so it fits with the StringArray format in strings.xml.
        TextView[] viewArray = {
                (TextView) findViewById(R.id.text_view_id),
                (Button) findViewById(R.id.button1),
                (Button) findViewById(R.id.button2),
                (Button) findViewById(R.id.button3),
                (Button) findViewById(R.id.button4)
        };

        //Assign quizvalues to relevant UI components.
        for(int i=0;i<viewArray.length;i++){
            viewArray[i].setText(quizValues[i]);
        }

        this.string = "Game!";

    }

    //Method called on all button's onClick()
    public void isCorrectAnswer(View v){

        Button b = (Button)v;
        Log.d("aktivitet",b.getText().toString());
        Log.d("aktivitet",quizValues[5]);

        //nextActivity();
        if(b.getText().toString().equals(quizValues[5])){
            nextActivity();
        }
        else{
            Log.d("aktivitet","Ikke korrekt svar");
            showEditDialog();
        }

        //Log.d("aktiviteter",v.getResources().getResourceEntryName(v.getId()));

    }

    //minQuiz and maxQuiz is the amount of implemented quizzes, starting at 1 because of string resource naming.
    //returns string values for views.
    public String[] selectQuiz() {
        int minQuiz = 1;
        int maxQuiz = 3;
        int quiz = randomInt(minQuiz, maxQuiz);
        String[] quizValues;
        if (quiz == 1) {
            return quizValues = getResources().getStringArray(R.array.q1);
        } else if (quiz == 2) {
            return quizValues = getResources().getStringArray(R.array.q2);
        } else if (quiz == 3) {
            return quizValues = getResources().getStringArray(R.array.q3);
        }
        return null;
    }

    private int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public void killThis(View v){
        //dismiss();
        editNameDialogFragment.dismiss();
    }
    PenaltyFragment editNameDialogFragment;
    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        editNameDialogFragment = PenaltyFragment.newInstance("Some Title");
        editNameDialogFragment.show(fm, "fragment_penalty");
    }


    public void nextGame(View view) {
        Log.d("aktivitet", "NY AKTIVITET!!!");
        Log.d("aktiviteter",view.getResources().getResourceEntryName(view.getId()));

        nextActivity();
        //finish();
    }
}