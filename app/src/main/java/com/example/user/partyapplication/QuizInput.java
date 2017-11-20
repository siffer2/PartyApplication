package com.example.user.partyapplication;

import android.content.Context;

/**
 * Created by User on 20-11-2017.
 */

public class QuizInput {

    public Context context;

    private String question;
    private String answer1, answer2, answer3, answer4;
    private int quizNumber = 0;

    public QuizInput(Context context){
        this.context = context;
    }
    private void setQuestionString(){
        question = context.getResources()
    }
}
