package com.example.androidstudiojavasayac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.math.MathUtils;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.Key;

public class SayacActivity extends AppCompatActivity {
    Button plusButton,minusButton,ayarlarButton;
    TextView textView;
    public static int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayac);
        SingletonSharedPreferences.getInstance(getApplicationContext());
        AyarlarActivity.soundChecked=SingletonSharedPreferences.soundGet();
        AyarlarActivity.vibrationChecked=SingletonSharedPreferences.vibrateGet();
        AyarlarActivity.upLimit=SingletonSharedPreferences.upLimitGet();
        AyarlarActivity.downLimit=SingletonSharedPreferences.downLimitGet();
        textView=(TextView)findViewById(R.id.sayacText);
        plusButton=(Button)findViewById(R.id.artibutonu);
        minusButton=(Button)findViewById(R.id.eksibutonu);
        ayarlarButton=(Button)findViewById(R.id.ayarlarbutonu);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterProcess(+1);
            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterProcess(-1);
            }
        });
        ayarlarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SayacActivity.this,AyarlarActivity.class));
            }
        });
        }
        public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_VOLUME_UP){
            counterProcess(+5);
            return true;
        }
        else if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN){
                counterProcess(-5);
                return true;
            }
        else{
            return super.onKeyDown(keyCode,event);
        }
        }
        public void counterProcess(int addition){
        final MediaPlayer alertSound=MediaPlayer.create(this,R.raw.beep_sound);
        if(addition+counter<AyarlarActivity.downLimit||addition+counter>AyarlarActivity.upLimit){
            if(AyarlarActivity.soundChecked){
                alertSound.start();
            }
            if(AyarlarActivity.vibrationChecked){
                ((Vibrator)getSystemService(Context.VIBRATOR_SERVICE)).vibrate(250);
            }
        }
        textView.setText(String.valueOf(counter= MathUtils.clamp(addition+counter,AyarlarActivity.downLimit,AyarlarActivity.upLimit)));
        }
    }
