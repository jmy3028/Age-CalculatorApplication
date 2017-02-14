package com.agecalculator.student.practiceapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Calendar;

public class Myage extends AppCompatActivity {

    private AdView mAdView;
    private EditText mMyageEditText;
    private Button mResultbutton;
    private TextView mAgedisplay;
    private TextView mAge2display;
    private TextView mAge3display;

    private int mAgeCalculation;
    private int mYearCalculation;
    private int mCalculation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myage);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mMyageEditText = (EditText) findViewById(R.id.my_age_editText);
        mResultbutton = (Button) findViewById(R.id.result_button);
        mAgedisplay = (TextView) findViewById(R.id.age_display);
        mAge2display = (TextView) findViewById(R.id.age2_display);
        mAge3display = (TextView) findViewById(R.id.age3_display);



                mResultbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String help = mMyageEditText.getText().toString();
                if (help.getBytes().length <= 0) {
                    Toast.makeText(Myage.this, "출생년도를 입력하세요!", Toast.LENGTH_SHORT).show();
                } else {
                    Calendar calendar = java.util.Calendar.getInstance();
                    mYearCalculation = calendar.get(calendar.YEAR);
                    mAgeCalculation = Integer.parseInt(mMyageEditText.getText().toString());

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mMyageEditText.getWindowToken(), 0);

                    mCalculation = mYearCalculation - mAgeCalculation + 1;
                    mAgedisplay.setText(mCalculation + "살");

                    mAge2display.setText("만 " + (mCalculation - 1) + "살");

                    mAge3display.setText("생일이 지나지 않았다면! 만 " + (mCalculation - 2) + "살");


                }


            }
        });

    }

}
