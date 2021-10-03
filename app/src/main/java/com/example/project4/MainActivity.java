package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private First mFirstFrag;
    private Second mSecondFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mbtnA = findViewById(R.id.btnA);
        Button mbtnB = findViewById(R.id.btnB);

        mbtnA.setOnClickListener(btnAOnClick);
        mbtnB.setOnClickListener(btnBOnClick);

        mFirstFrag = new First();
        mSecondFrag = new Second();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLay, mFirstFrag, "First Fragment")
                .add(R.id.frameLay, mSecondFrag, "Second Fragment")
                .hide(mSecondFrag)
                .commit();
    }

    private View.OnClickListener btnAOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getSupportFragmentManager().beginTransaction()
                    .show(mFirstFrag)
                    .hide(mSecondFrag)
                    .commit();
        }
    };

    private View.OnClickListener btnBOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getSupportFragmentManager().beginTransaction()
                    .show(mSecondFrag)
                    .hide(mFirstFrag)
                    .commit();
        }
    };

}