package com.agecalculator.student.practiceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.agecalculator.student.practiceapp.R.layout.activity_main);

        findViewById(com.agecalculator.student.practiceapp.R.id.my_age_button).setOnClickListener(this);
        findViewById(com.agecalculator.student.practiceapp.R.id.parents_age_button).setOnClickListener(this);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case com.agecalculator.student.practiceapp.R.id.my_age_button:
                Intent my_age_button = new Intent(this, Myage.class);
                startActivity(my_age_button);
                break;
            case com.agecalculator.student.practiceapp.R.id.parents_age_button:
                Intent parents_age_buttot = new Intent(this, MyParents.class);
                startActivity(parents_age_buttot);
                break;
        }
    }
}