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

public class MyParents extends AppCompatActivity {

    private AdView mAdView;
    private EditText mMyageEditText;
    private EditText mParentsageEditText;
    private Button mResultbutton;
    private TextView mAgedisplay;
    private TextView mTextdisplay;

    private int mAgeCalculation;
    private int mParAgeCalculation;
    private int mCalculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_parents);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mMyageEditText = (EditText) findViewById(R.id.my_age_editText);
        mParentsageEditText = (EditText) findViewById(R.id.parents_age_editText);
        mResultbutton = (Button) findViewById(R.id.result_button);
        mAgedisplay = (TextView) findViewById(R.id.age_display);
        mTextdisplay = (TextView) findViewById(R.id.text_display);

        mResultbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String help = mMyageEditText.getText().toString();
                String helper = mMyageEditText.getText().toString();
                if (help.getBytes().length <= 0 && helper.getBytes().length <= 0) {
                    Toast.makeText(MyParents.this, "출생년도를 입력하세요!", Toast.LENGTH_SHORT).show();
                } else {
                    mAgeCalculation = Integer.parseInt(mMyageEditText.getText().toString());
                    mParAgeCalculation = Integer.parseInt(mParentsageEditText.getText().toString());

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mMyageEditText.getWindowToken(), 0);
                    InputMethodManager imm2 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mParentsageEditText.getWindowToken(), 0);

                    mCalculation = mAgeCalculation - mParAgeCalculation;
                    mAgedisplay.setText(mCalculation + "살");
                    mTextdisplay.setText("차이가 납니다!");


                }

            }
        });

    }
}
