package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private First mFirstFrag;
    private Second mSecondFrag;
    private Third mThirdFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mbtnA = findViewById(R.id.btnA);
        Button mbtnB = findViewById(R.id.btnB);
        Button mbtnC = findViewById(R.id.btnC);

        mbtnA.setOnClickListener(btnAOnClick);
        mbtnB.setOnClickListener(btnBOnClick);
        mbtnC.setOnClickListener(btnCOnClick);

        mFirstFrag = new First();
        mSecondFrag = new Second();
        mThirdFrag = new Third();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLay, mFirstFrag, "First Fragment")
                .add(R.id.frameLay, mSecondFrag, "Second Fragment")
                .add(R.id.frameLay, mThirdFrag, "Third Fragment")
                .hide(mSecondFrag)
                .hide(mThirdFrag)
                .commit();
    }

    private View.OnClickListener btnAOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getSupportFragmentManager().beginTransaction()
                    .show(mFirstFrag)
                    .hide(mSecondFrag)
                    .hide(mThirdFrag)
                    .commit();
        }
    };

    private View.OnClickListener btnBOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getSupportFragmentManager().beginTransaction()
                    .show(mSecondFrag)
                    .hide(mFirstFrag)
                    .hide(mThirdFrag)
                    .commit();
        }
    };
    private View.OnClickListener btnCOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getSupportFragmentManager().beginTransaction()
                    .show(mThirdFrag)
                    .hide(mFirstFrag)
                    .hide(mSecondFrag)
                    .commit();
        }
    };


}