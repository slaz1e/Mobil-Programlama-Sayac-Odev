package com.example.androidstudiojavasayac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class AyarlarActivity extends AppCompatActivity {
    public static int upLimit,downLimit;
    public static boolean soundChecked,vibrationChecked;
    Button plusUpLimit,minusUpLimit,plusDownLimit,minusDownLimit;
    TextView upperLimit,lowerLimit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);
        plusUpLimit=(Button)findViewById(R.id.plusUpLimitbtn);
        minusUpLimit=(Button)findViewById(R.id.minusUpLimitbtn);
        plusDownLimit=(Button)findViewById(R.id.plusDownLimitbtn);
        minusDownLimit=(Button)findViewById(R.id.minusDownLimitbtn);
        upperLimit=(TextView) findViewById(R.id.upLimitText);
        lowerLimit=(TextView) findViewById(R.id.downLimitText);
        CheckBox sound_checkbox=(findViewById(R.id.sesBox));
        sound_checkbox.setChecked(soundChecked);
        CheckBox vibrate_checkbox=(findViewById(R.id.titresimBox));
        vibrate_checkbox.setChecked(vibrationChecked);
        sound_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                soundChecked=b;
                SingletonSharedPreferences.soundSet(soundChecked);
            }
        });
        vibrate_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                vibrationChecked=b;
                SingletonSharedPreferences.vibrateSet(vibrationChecked);
            }
        });
        plusUpLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upLimit++;
                upperLimit.setText(String.valueOf(upLimit));
                SingletonSharedPreferences.upLimitSet(upLimit);
            }
        });
        minusUpLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upLimit--;
                upperLimit.setText(String.valueOf(upLimit));
                SingletonSharedPreferences.upLimitSet(upLimit);
            }
        });
        plusDownLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downLimit++;
                lowerLimit.setText(String.valueOf(downLimit));
                SingletonSharedPreferences.downLimitSet(downLimit);
            }
        });
        minusDownLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downLimit--;
                lowerLimit.setText(String.valueOf(downLimit));
                SingletonSharedPreferences.downLimitSet(downLimit);
            }
        });
        };
    }
