package com.example.user.partyapplication;

import android.icu.util.IslamicCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.ThreadLocalRandom;

public class CardActivity extends UpdatableActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);


        imageView = (ImageView) findViewById(R.id.cardImage);
        textView = (TextView) findViewById(R.id.cardText);

        selectCard();
    }

    private void selectCard(){
        int cardNumber = randomInt(1,2);
        if(cardNumber==1){
            isDuplicateActivity("hand");
            imageView.setImageResource(R.drawable.hand);
            textView.setText(R.string.handString);
        }
        else if(cardNumber==2){
            isDuplicateActivity("got");
            imageView.setImageResource(R.drawable.got);
            textView.setText(R.string.gotString);
        }
    }

    private int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public void nextGame(View view) {
        nextActivity();
        finish();
    }
}
