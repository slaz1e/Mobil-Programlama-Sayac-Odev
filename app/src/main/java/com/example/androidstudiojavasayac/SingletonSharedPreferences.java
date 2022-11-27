package com.example.androidstudiojavasayac;

import android.content.Context;
import android.content.SharedPreferences;

public class SingletonSharedPreferences {
    private static SingletonSharedPreferences singletonSharedPreferences=null;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;
    Context context;

    public static SingletonSharedPreferences getInstance(Context context){
        if(singletonSharedPreferences==null){
            singletonSharedPreferences=new SingletonSharedPreferences(context);
        }
        return singletonSharedPreferences;
    }
    private SingletonSharedPreferences(Context context){
        this.context=context;
        preferences=context.getSharedPreferences("shared",Context.MODE_PRIVATE);
        editor=preferences.edit();
    }
    public static int upLimitGet(){
        return preferences.getInt("uplimit",0);
    }
    public static void upLimitSet(int value){
        editor.putInt("uplimit",value);
        editor.apply();
    }
    public static int downLimitGet(){
        return preferences.getInt("downlimit",0);
    }
    public static void downLimitSet(int value){
        editor.putInt("downlimit",value);
        editor.apply();
    }
    public static boolean soundGet(){
        return preferences.getBoolean("ses",true);
    }
    public static void soundSet(boolean bool){
        editor.putBoolean("ses",bool);
        editor.apply();
    }
    public static boolean vibrateGet(){
        return preferences.getBoolean("vibrate",true);
    }
    public static void vibrateSet(boolean bool){
        editor.putBoolean("vibrate",bool);
        editor.apply();
    }
}
