package com.nnxy.application;

import android.app.Application;

import com.nnxy.dbmanager.UserUtils;

public class MyApplication extends Application {
    private static UserUtils userUtils;
    @Override
    public void onCreate() {
        super.onCreate();
        userUtils=new UserUtils(getApplicationContext());
    }


    public static UserUtils getUserUtils() {
        return userUtils;
    }
}
