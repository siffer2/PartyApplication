package com.example.user.partyapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.DialogFragment;
import android.view.WindowManager;



public class PenaltyFragment extends DialogFragment {

    public PenaltyFragment() {
    }

    public static PenaltyFragment newInstance(String title) {
        PenaltyFragment frag = new PenaltyFragment();
        //Bundle args = new Bundle();
        //args.putString("title", title);
        //frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_penalty, container);
    }


}

